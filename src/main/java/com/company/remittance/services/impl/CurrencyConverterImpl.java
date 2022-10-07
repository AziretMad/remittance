package com.company.remittance.services.impl;

import com.company.remittance.entities.Currency;
import com.company.remittance.entities.ExchangeRate;
import com.company.remittance.repositories.ExchangeRateRepository;
import com.company.remittance.services.CurrencyConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrencyConverterImpl implements CurrencyConverter {
    private final ExchangeRateRepository exchangeRateRepository;


    @Override
    public BigDecimal convert(BigDecimal amount, Currency currency, Currency converted) {
        Optional<ExchangeRate> result = exchangeRateRepository.findByCurrencyAndConverted(currency, converted);
        if (result.isPresent()) {
            return amount.divide(result.get().getBuyRate(), 2, RoundingMode.HALF_UP);
        }
        ExchangeRate rate = exchangeRateRepository
                .findByCurrencyAndConverted(converted, currency)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Exchange rate not found. Currency: " + currency.getCode() + "Converted: " + converted.getCode()
                ));
        return amount.multiply(rate.getSellRate()).setScale(2, RoundingMode.HALF_UP);
    }
}
