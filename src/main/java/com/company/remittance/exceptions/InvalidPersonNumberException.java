package com.company.remittance.exceptions;

public class InvalidPersonNumberException extends IllegalArgumentException {
    public InvalidPersonNumberException(String message) {
        super(message);
    }
}
