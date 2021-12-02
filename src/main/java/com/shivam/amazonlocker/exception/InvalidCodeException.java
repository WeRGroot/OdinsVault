package com.shivam.amazonlocker.exception;

public class InvalidCodeException extends RuntimeException {
    private static final String INVALID_CODE_MSG = "Invalid code exception";

    public InvalidCodeException() {
        super(INVALID_CODE_MSG);
    }
}
