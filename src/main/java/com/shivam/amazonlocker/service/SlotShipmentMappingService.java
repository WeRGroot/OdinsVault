package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.model.locker.SlotShipment;
import com.shivam.amazonlocker.repository.SlotShipmentRepository;

public class SlotShipmentMappingService {
    private SlotShipmentRepository slotShipmentRepository = new SlotShipmentRepository();

    public void addSlotShipment(SlotShipment slotShipment){
        slotShipmentRepository.addMapping(slotShipment);
    }

    public SlotShipment getShipmentId(String slotId){
        return slotShipmentRepository.getShipmentId(slotId);
    }

    public SlotShipment getSlotId(String shipmentId){
        return slotShipmentRepository.getSlotId(shipmentId);
    }

    public boolean removeMapping(String slotId, String shipmentId){
        return slotShipmentRepository.removeMapping(slotId, shipmentId);
    }
}
