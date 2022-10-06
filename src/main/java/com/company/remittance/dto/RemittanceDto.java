package com.company.remittance.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceDto {
    String senderNumber;
    String receiverNumber;
    BigDecimal amount;
    String comment;
}
