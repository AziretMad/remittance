package com.company.remittance.repositories;

import com.company.remittance.entities.Currency;
import com.company.remittance.entities.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> findByCurrencyAndConverted(Currency currency, Currency converted);
}
