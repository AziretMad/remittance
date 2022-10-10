package com.company.remittance.services;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.dto.RemittanceFilter;
import com.company.remittance.entities.Remittance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;


public interface RemittanceService {
    List<Remittance> findAll();
    Page<Remittance> findByFilter(RemittanceFilter filter, Pageable pageable);
    Remittance save(RemittanceDto remittanceDto);
    Remittance grant(String code);
}
