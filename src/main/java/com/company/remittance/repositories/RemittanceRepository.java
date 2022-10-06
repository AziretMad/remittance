package com.company.remittance.repositories;

import com.company.remittance.entities.Remittance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemittanceRepository extends JpaRepository<Remittance, Long> {
    Page<Remittance> findAll(Pageable pageable);
}
