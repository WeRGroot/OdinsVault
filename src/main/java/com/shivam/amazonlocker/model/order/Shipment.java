package com.shivam.amazonlocker.model.order;

import com.shivam.amazonlocker.model.GeoLocation;
import com.shivam.amazonlocker.model.locker.SlotSize;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shipment {
    private String shipmentId;
    private List<Item> items;
    private String lockerId;
}
