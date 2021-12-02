package com.shivam.amazonlocker.model.notification;

import com.shivam.amazonlocker.exception.CodeExpiredException;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Code {
    private String codeId;
    private int code;
    private int validityTimeInDays;    // no of days
    private String slotId;
    @Setter private LocalDateTime packageDeliverTime;

    public Code(String slotId, int validityTimeInDays){
        this.codeId = UUID.randomUUID().toString();
        this.slotId = slotId;
        this.validityTimeInDays = validityTimeInDays;
        this.code = (int)Math.random() * 10000;
    }

    public boolean verifyCode(Code code) throws CodeExpiredException {
        if(code == null || code.getPackageDeliverTime() == null){
            return false;
        }
        if(LocalDateTime.now().compareTo(packageDeliverTime) > validityTimeInDays){
            throw new CodeExpiredException();
        }
        return (this.code == code.getCode());
    }
}
