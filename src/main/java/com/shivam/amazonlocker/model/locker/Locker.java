package com.shivam.amazonlocker.model.locker;

import com.shivam.amazonlocker.model.GeoLocation;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locker {
    private String lockerId;
    private List<LockerSlot> lockerSlots = new ArrayList<>();
    private GeoLocation geoLocation;
    private LocationTiming locationTiming;

    public Locker(String lockerId, GeoLocation geoLocation,
        LocationTiming locationTiming) {
        this.lockerId = lockerId;
        this.geoLocation = geoLocation;
        this.locationTiming = locationTiming;
    }
}
