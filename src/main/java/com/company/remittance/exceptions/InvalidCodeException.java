package com.company.remittance.exceptions;

public class InvalidCodeException extends IllegalArgumentException {
    public InvalidCodeException(String s) {
        super(s);
    }
}
