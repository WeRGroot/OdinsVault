package com.shivam.amazonlocker.exception;

public class CodeExpiredException extends Exception {
    private static final String CODE_EXPIRED_EXCEPTION = "Given code got expired";

    public CodeExpiredException() {
        super(CODE_EXPIRED_EXCEPTION);
    }
}
