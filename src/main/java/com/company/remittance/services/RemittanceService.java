package com.company.remittance.services;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.entities.Remittance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RemittanceService {
    Page<Remittance> findAll(Pageable pageable);
    Remittance save(RemittanceDto remittanceDto);
}
