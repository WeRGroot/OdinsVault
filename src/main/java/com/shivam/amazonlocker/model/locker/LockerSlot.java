package com.shivam.amazonlocker.model.locker;

import com.shivam.amazonlocker.utils.IdGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LockerSlot {
    private String slotId;
    private String lockerId;
    private SlotSize lockerSlotSize;
    private LockerSlotStatus lockerSlotStatus;

    public LockerSlot(String lockerId, SlotSize lockerSlotSize) {
        this.slotId = IdGenerator.generateId(8);
        this.lockerId = lockerId;
        this.lockerSlotSize = lockerSlotSize;
    }

    public boolean isAvailable(){
        return lockerSlotStatus == LockerSlotStatus.AVAILABLE;
    }
}
