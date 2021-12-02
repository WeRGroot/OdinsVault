package com.shivam.amazonlocker.exception;

public class SlotAlreadyOccupiedException extends RuntimeException {
    public static final String SLOT_ALREADY_OCCUPIED_EXCEPTION = "Given slot is already occupied";

    public SlotAlreadyOccupiedException(String message) {
        super(message);
    }
}
