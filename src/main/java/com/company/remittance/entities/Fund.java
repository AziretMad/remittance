package com.company.remittance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Fund extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String name;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;
}
