package com.company.remittance.repositories;

import com.company.remittance.entities.Remittance;
import com.company.remittance.enums.RemittanceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RemittanceRepository extends JpaRepository<Remittance, Long> {
    @Query("select r from Remittance r " +
            "where (:status is null or r.status=:status) and" +
            "(cast(:dateFrom as date) is null or r.createdDate >= :dateFrom) and" +
            "(cast(:dateTo as date) is null or r.createdDate <= :dateTo)")
    Page<Remittance> findByFilter(
            @Param("status") RemittanceStatus status,
            @Param("dateFrom") Date dateFrom,
            @Param("dateTo") Date dateTo,
            Pageable pageable
    );

    Optional<Remittance> findByCodeAndStatus(UUID code, RemittanceStatus status);
}
