package com.company.remittance.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RemittanceDto {
    @NotNull
    @NotBlank
    String senderNumber;
    @NotNull
    @NotBlank
    String receiverNumber;
    @NotNull
    @DecimalMin(value = "10.00")
    @Digits(integer = 5, fraction = 2)
    BigDecimal amount;
    String comment;
}
