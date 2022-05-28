package com.lab.mspartner.exception;

public class PartnerException extends RuntimeException {

    public PartnerException(String message) {
        super(message);
    }

    public PartnerException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
