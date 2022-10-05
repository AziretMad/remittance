package com.company.remittance.services.impl;

import com.company.remittance.services.RemittanceService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.awt.print.Pageable;

@Service
public class RemittanceServiceImpl implements RemittanceService {

    @Override
    public Page<Book> find(Pageable pageable) {
        return null;
    }
}
