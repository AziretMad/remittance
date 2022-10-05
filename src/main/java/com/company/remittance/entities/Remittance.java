package com.company.remittance.entities;

import com.company.remittance.enums.RemittanceStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Remittance extends AbstractEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;
    @Column(unique = true, nullable = false)
    private UUID code = UUID.randomUUID();
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RemittanceStatus status = RemittanceStatus.CREATED;
}
