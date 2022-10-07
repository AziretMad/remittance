package com.company.remittance.services.impl;

import com.company.remittance.entities.Fund;
import com.company.remittance.repositories.FundRepository;
import com.company.remittance.services.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {
    private FundRepository fundRepository;


    @Override
    public List<Fund> saveAll(Iterable<Fund> funds) {
        return fundRepository.saveAll(funds);
    }
}
