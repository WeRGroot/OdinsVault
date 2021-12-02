package com.shivam.amazonlocker.repository;

import com.shivam.amazonlocker.exception.NoSuchInventoryItemException;
import com.shivam.amazonlocker.exception.SlotAlreadyOccupiedException;
import com.shivam.amazonlocker.model.locker.SlotShipment;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SlotShipmentRepository {
    Map<String, SlotShipment> slotShipmentMap = new HashMap<>();

    public SlotShipment getShipmentId(String slotId){
        if(!slotShipmentMap.containsKey(slotId)){
            throw new NoSuchInventoryItemException(NoSuchInventoryItemException.NO_SLOT_PRESENT);
        }
        return slotShipmentMap.get(slotId);
    }

    public SlotShipment getSlotId(String shipmentId){
        for (Entry<String, SlotShipment> entry : slotShipmentMap.entrySet()) {
            if(entry.getValue().getShipmentId().equals(shipmentId)){
                return entry.getValue();
            }
        }

        throw new NoSuchInventoryItemException(NoSuchInventoryItemException.NO_SHIPMENT_PRESENT);
    }

    public void addMapping(SlotShipment slotShipment){
        if(slotShipmentMap.containsKey(slotShipment.getSlotId())){
            throw new SlotAlreadyOccupiedException(SlotAlreadyOccupiedException.SLOT_ALREADY_OCCUPIED_EXCEPTION);
        }
        slotShipmentMap.put(slotShipment.getSlotId(), slotShipment);
    }

    public boolean removeMapping(String slotId, String shipmentId){
        if(slotShipmentMap.containsKey(slotId)){
            throw new NoSuchInventoryItemException(NoSuchInventoryItemException.NO_SLOT_PRESENT);
        }
        return slotShipmentMap.remove(slotId, shipmentId);
    }
}
