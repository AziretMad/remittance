package com.company.remittance.services.impl;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.entities.Remittance;
import com.company.remittance.repositories.RemittanceRepository;
import com.company.remittance.services.RemittanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemittanceServiceImpl implements RemittanceService {
    private final RemittanceRepository remittanceRepository;


    @Override
    public Page<Remittance> findAll(Pageable pageable) {
        return remittanceRepository.findAll(pageable);
    }

    @Override
    public Remittance save(RemittanceDto remittanceDto) {
        return null;
    }
}
