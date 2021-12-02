package com.shivam.amazonlocker.model.order;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String orderId;
    private Map<String, Shipment> shipments;

    public Shipment getShipment(String shipmentId){
        return shipments.get(shipmentId);
    }

    public boolean addShipment(Shipment shipment){
        if(shipments.containsKey(shipment.getShipmentId())){
            return false;
        }

        shipments.put(shipment.getShipmentId(), shipment);
        return true;
    }
}
