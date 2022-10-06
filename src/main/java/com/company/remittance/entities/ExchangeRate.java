package com.company.remittance.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class ExchangeRate extends AbstractEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "converted_id", nullable = false)
    private Currency converted;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal buyRate;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal sellRate;

    public ExchangeRate(Currency currency, Currency converted, BigDecimal buyRate, BigDecimal sellRate) {
        this.currency = currency;
        this.converted = converted;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }
}
