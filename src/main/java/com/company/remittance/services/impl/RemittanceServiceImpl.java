package com.company.remittance.services.impl;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.dto.RemittanceFilter;
import com.company.remittance.entities.Fund;
import com.company.remittance.entities.Person;
import com.company.remittance.entities.Remittance;
import com.company.remittance.enums.RemittanceStatus;
import com.company.remittance.exceptions.GrantImpossibleException;
import com.company.remittance.exceptions.NotEnoughFundsException;
import com.company.remittance.repositories.FundRepository;
import com.company.remittance.repositories.RemittanceRepository;
import com.company.remittance.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemittanceServiceImpl implements RemittanceService {
    private final RemittanceRepository remittanceRepository;
    private final PersonService personService;
    private final AuthService authService;
    private final CurrencyConverter currencyConverter;
    private final FundRepository fundRepository;


    @Override
    public List<Remittance> findAll() {
        return remittanceRepository.findAll();
    }

    @Override
    public Page<Remittance> findByFilter(RemittanceFilter filter, Pageable pageable) {
        return remittanceRepository.findByFilter(filter.getStatus(), filter.getFrom(), filter.getTo(), pageable);
    }

    @Override
    @Transactional
    public Remittance save(RemittanceDto remittanceDto) {
        Person sender = personService.find(remittanceDto.getSenderNumber());
        Person receiver = personService.find(remittanceDto.getReceiverNumber());
        Fund fund = authService.getCurrentUser().getFund();
        return remittanceRepository.save(
                new Remittance(
                        sender,
                        receiver,
                        remittanceDto.getAmount(),
                        fund.getCurrency(),
                        remittanceDto.getComment(),
                        fund
                )
        );
    }

    @Override
    @Transactional
    public Remittance grant(String code) {
        Remittance remittance = remittanceRepository
                .findByCodeAndStatus(UUID.fromString(code), RemittanceStatus.CREATED)
                .orElseThrow(() -> new EntityNotFoundException("Remittance not found. Code: " + code));
        Fund fund = authService.getCurrentUser().getFund();
        Fund creator = remittance.getCreator();
        BigDecimal grantedAmount = remittance.getAmount();

        if (fund.equals(remittance.getCreator()))
            throw new GrantImpossibleException("Creator fund can't grunt this remittance");
        if (creator.getBalance().compareTo(remittance.getAmount()) < 0)
            throw new NotEnoughFundsException("Creator doesn't have enough funds in balance");
        if (!fund.getCurrency().equals(remittance.getCurrency())) {
            grantedAmount = currencyConverter.convert(remittance.getAmount(), remittance.getCurrency(), fund.getCurrency());
        }

        creator.setBalance(creator.getBalance().subtract(remittance.getAmount()).setScale(2, RoundingMode.HALF_UP));
        fund.setBalance(fund.getBalance().add(grantedAmount).setScale(2, RoundingMode.HALF_UP));

        fundRepository.save(creator);
        fundRepository.save(fund);

        remittance.setStatus(RemittanceStatus.GRANTED);
        remittance.setGranter(fund);

        return remittanceRepository.save(remittance);
    }
}
