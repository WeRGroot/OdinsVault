package com.shivam.amazonlocker.repository;

import com.shivam.amazonlocker.exception.InvalidLockerException;
import com.shivam.amazonlocker.model.GeoLocation;
import com.shivam.amazonlocker.model.locker.Locker;
import com.shivam.amazonlocker.model.locker.LockerSlot;
import com.shivam.amazonlocker.model.locker.LockerSlotStatus;
import com.shivam.amazonlocker.model.locker.SlotSize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LockerRepository {

    private static final int MAX_RADIUS_OF_SEARCH = 2;
    public static Map<String, Locker> lockerStore = new HashMap<>();

    public List<Locker> getLockers(GeoLocation geoLocation){
        List<Locker> lockerList = lockerStore.values().stream()
            .filter(locker -> locker.getGeoLocation().distance(geoLocation) <= MAX_RADIUS_OF_SEARCH)
            .collect(Collectors.toList());

        return lockerList;
    }

    public LockerSlot getAvailableLockerSlot(GeoLocation geoLocation, SlotSize slotSize){
        List<Locker> lockersInTheRegion = getLockers(geoLocation);
        for(Locker locker : lockersInTheRegion){
            for(LockerSlot lockerSlot : locker.getLockerSlots()){
                if(lockerSlot.getLockerSlotStatus() == LockerSlotStatus.AVAILABLE
                    && lockerSlot.getLockerSlotSize() == slotSize){
                    return lockerSlot;
                }
            }
        }

        return null;
    }

    public void addLocker(Locker locker){
        if(locker == null || !lockerStore.containsKey(locker.getLockerId())){
            throw new InvalidLockerException();
        }

        lockerStore.put(locker.getLockerId(), locker);
    }

    public void addSlots(String lockerId, List<LockerSlot> slots){
        if(!lockerStore.containsKey(lockerId) || slots==null){
            throw new InvalidLockerException("Invalid Locker/slot list exception");
        }

        lockerStore.get(lockerId).getLockerSlots().addAll(slots);
     }

     public Locker getLocker(String lockerId){
         if(lockerId == null || !lockerStore.containsKey(lockerId)){
             throw new InvalidLockerException();
         }

         return lockerStore.get(lockerId);
     }

     public Optional<LockerSlot> getAvailableLockerSlot(String lockerId, SlotSize slotSize){
         return getLocker(lockerId).getLockerSlots()
             .stream()
             .filter(slot -> slot.isAvailable() && slot.getLockerSlotSize() == slotSize)
             .findFirst();
     }
}
