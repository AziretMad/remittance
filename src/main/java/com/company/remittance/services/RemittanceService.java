package com.company.remittance.services;

import com.company.remittance.entities.Remittance;
import org.springframework.data.domain.Page;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;

public interface RemittanceService {
    Page<Book> find(Pageable pageable);
}
