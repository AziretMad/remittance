package com.company.remittance.services;

import com.company.remittance.entities.Currency;

import java.math.BigDecimal;

public interface CurrencyConverter {
    BigDecimal convert(BigDecimal amount, Currency currency, Currency converted);
}
