package com.shivam.amazonlocker.model.locker;

import com.shivam.amazonlocker.exception.CodeExpiredException;
import com.shivam.amazonlocker.model.notification.Code;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SlotShipment {
    final int codeValidity = 3; // 3 days
    private String slotId;
    private String shipmentId;
    private Code code;
    private LocalDateTime packageDeliverTime;

    public boolean isValidCode(Code code) throws CodeExpiredException{
        return this.code.verifyCode(code);
    }
}
