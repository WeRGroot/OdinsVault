package com.shivam.amazonlocker.model.notification;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SimpleMessage implements Message{

    public static final String PACKAGE_DELIVERY_MESSAGE = "This is to be notified that"
        + " your shipment %s has been delivered "
        + "to locker %s, slot %s. "
        + "The OTP to open the locker is %s";

    public static final String ORDER_PLACED_MESSAGE = "This is to be notified that"
        + " your order %s has been placed successfully.";

    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
