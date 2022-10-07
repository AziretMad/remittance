package com.company.remittance.entities;

import com.company.remittance.enums.RemittanceStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Remittance extends AbstractEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Person sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Person receiver;
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
    private Date createdDate = new Date();
    @Column(length = 500)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Fund creator;
    @ManyToOne
    @JoinColumn(name = "granter_id")
    private Fund granter;

    public Remittance(
            Person sender,
            Person receiver,
            BigDecimal amount,
            Currency currency,
            String comment,
            Fund creator
    ) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
        this.creator = creator;
    }
}
