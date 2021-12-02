package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.exception.NoLockerAvailableException;
import com.shivam.amazonlocker.model.locker.LockerSlot;
import com.shivam.amazonlocker.model.locker.LockerSlotStatus;
import com.shivam.amazonlocker.model.locker.SlotShipment;
import com.shivam.amazonlocker.model.locker.SlotSize;
import com.shivam.amazonlocker.model.notification.Code;
import com.shivam.amazonlocker.model.notification.Message;
import com.shivam.amazonlocker.model.notification.SimpleMessage;
import com.shivam.amazonlocker.model.order.Shipment;
import com.shivam.amazonlocker.utils.SizeUtils;
import java.time.LocalDateTime;
import java.util.Optional;

public class DeliveryService {

    private LockerService lockerService = new LockerService();
    private OrderService orderService = new OrderService();
    private SlotShipmentMappingService slotShipmentMappingService = new SlotShipmentMappingService();
    private NotificationService notificationService = new ConsoleNotificationService();

    public void deliver(String orderId, String shipmentId){
        Shipment shipment = orderService.getOrder(orderId).getShipment(shipmentId);
        SlotSize slotSize = SizeUtils.getSlotSize(shipment);
        Optional<LockerSlot> lockerSlotOptional =
            lockerService.getLockerSlot(shipment.getLockerId(), slotSize);
        if(!lockerSlotOptional.isPresent()){
            throw new NoLockerAvailableException(NoLockerAvailableException.LOCKER_NOT_AVAILABLE);
        }
        LockerSlot slot = lockerSlotOptional.get();

        Code code = new Code(slot.getSlotId(), 3);
        SlotShipment slotShipment = new SlotShipment(slot.getSlotId(), shipmentId, code,
            LocalDateTime.now());

        slotShipmentMappingService.addSlotShipment(slotShipment);
        slot.setLockerSlotStatus(LockerSlotStatus.BOOKED);
        Message message = new SimpleMessage(
            String.format(SimpleMessage.PACKAGE_DELIVERY_MESSAGE, shipmentId, slot.getLockerId(), slot.getSlotId(), code.getCode()));
        notificationService.sendMessage(message);
    }

    public void pickupDeliveredShipment(String slotId, int code){

    }
}
