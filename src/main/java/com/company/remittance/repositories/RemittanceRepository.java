package com.company.remittance.repositories;

import com.company.remittance.entities.Remittance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemittanceRepository extends JpaRepository<Remittance, Long> {
}
