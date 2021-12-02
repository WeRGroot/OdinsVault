package com.shivam.amazonlocker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeoLocation {
    private double latitude;
    private double longitude;

    public double distance(GeoLocation geoLocation2){
        return Math.sqrt(
            Math.pow(this.latitude - geoLocation2.getLatitude(), 2) +
            Math.pow(this.longitude - geoLocation2.getLongitude(), 2));
    }
}
