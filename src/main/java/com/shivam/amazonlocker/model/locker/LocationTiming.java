package com.shivam.amazonlocker.model.locker;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationTiming {

    public static final LocationTiming NORMAL_10AM_TO_6PM = new LocationTiming();

    static {
        Map<DayOfWeek, Timing> timingMap = new HashMap<>();
        timingMap.put(DayOfWeek.MONDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.TUESDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.WEDNESDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.THURSDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.FRIDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.SATURDAY, new Timing("10:00", "18:00"));
        timingMap.put(DayOfWeek.SUNDAY, new Timing("10:00", "18:00"));

        NORMAL_10AM_TO_6PM.setTimingMap(timingMap);
    }

    private Map<DayOfWeek, Timing> timingMap = new HashMap<>();
}
