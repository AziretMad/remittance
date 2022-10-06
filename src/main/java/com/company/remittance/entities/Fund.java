package com.company.remittance.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Fund extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String name;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    public Fund(String name, BigDecimal balance, Currency currency) {
        this.name = name;
        this.balance = balance;
        this.currency = currency;
    }
}
