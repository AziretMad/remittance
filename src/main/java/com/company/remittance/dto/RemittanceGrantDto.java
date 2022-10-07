package com.company.remittance.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RemittanceGrantDto {
    @NotNull
    @NotBlank
    private String code;
}
