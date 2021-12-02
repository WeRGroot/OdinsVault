package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.model.locker.LockerSlot;
import com.shivam.amazonlocker.model.locker.SlotSize;
import com.shivam.amazonlocker.repository.LockerRepository;
import java.util.Optional;

public class LockerService {

    LockerRepository lockerRepository = new LockerRepository();

    public Optional<LockerSlot> getLockerSlot(String lockerId, SlotSize slotSize){
        return lockerRepository.getAvailableLockerSlot(lockerId, slotSize);
    }
}
