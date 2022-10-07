package com.company.remittance.services;

import com.company.remittance.entities.Fund;

import java.util.List;

public interface FundService {
    List<Fund> saveAll(Iterable<Fund> funds);
}
