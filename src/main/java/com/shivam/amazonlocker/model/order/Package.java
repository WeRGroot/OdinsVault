package com.shivam.amazonlocker.model.order;

import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Package {
    private String packageId;
    private List<String> shipmentIds;
    private double packageSize;

    public Package(List<String> shipmentIds) {
        this.packageId = UUID.randomUUID().toString();
        this.shipmentIds = shipmentIds;
        this.packageSize = Math.random() * 10;
    }
}
