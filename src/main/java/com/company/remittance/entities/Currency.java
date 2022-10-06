package com.company.remittance.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class Currency extends AbstractEntity<Short> {
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String code;

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
