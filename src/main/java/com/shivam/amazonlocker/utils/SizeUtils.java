package com.shivam.amazonlocker.utils;

import com.shivam.amazonlocker.model.locker.SlotSize;
import com.shivam.amazonlocker.model.order.Shipment;

public class SizeUtils {
    public static SlotSize getSlotSize(Shipment shipment){
        int size = shipment.hashCode() % 6;
        switch (size){
            case 0:
                return SlotSize.XS;
            case 1:
                return SlotSize.S;
            case 2:
                return SlotSize.M;
            case 3:
                return SlotSize.L;
            case 4:
                return SlotSize.XL;
            default:
                return SlotSize.XLL;
        }
    }
}
