package com.shivam.amazonlocker.exception;

public class InvalidLockerException extends RuntimeException {
    private static final String INVALID_LOCKER_EXCEPTION = "Invalid locker exception";

    public InvalidLockerException() {
        super(INVALID_LOCKER_EXCEPTION);
    }

    public InvalidLockerException(String message) {
        super(message);
    }
}
