package com.shivam.amazonlocker.exception;

public class NoLockerAvailableException extends RuntimeException {
    public static final String LOCKER_NOT_AVAILABLE = "No locker of given size is present";

    public NoLockerAvailableException(String message) {
        super(message);
    }
}
