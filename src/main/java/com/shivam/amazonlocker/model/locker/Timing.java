package com.shivam.amazonlocker.model.locker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class Timing {

    private LocalTime openTime;
    private LocalTime closeTime;

    public Timing(String openTime, String closeTime) {
        this(openTime, closeTime, DateTimeFormatter.ISO_TIME);
    }

    public Timing(String openTime, String closeTime, DateTimeFormatter timeFormatter) {
        this.openTime = LocalTime.parse(openTime, timeFormatter);
        this.closeTime = LocalTime.parse(closeTime, timeFormatter);
    }
}
