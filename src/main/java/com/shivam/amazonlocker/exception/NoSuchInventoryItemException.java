package com.shivam.amazonlocker.exception;

public class NoSuchInventoryItemException extends RuntimeException {
    public static final String NO_SHIPMENT_PRESENT = "No shipment present for given id";
    public static final String NO_SLOT_PRESENT = "No slot present for given id";

    public NoSuchInventoryItemException(String message) {
        super(message);
    }
}
