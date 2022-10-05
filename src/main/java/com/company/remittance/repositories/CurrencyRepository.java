package com.company.remittance.repositories;

import com.company.remittance.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Short> {
}
