package com.company.remittance.repositories;

import com.company.remittance.entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Long> {
}
