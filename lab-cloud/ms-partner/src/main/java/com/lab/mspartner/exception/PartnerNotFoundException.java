package com.lab.mspartner.exception;

public class PartnerNotFoundException extends RuntimeException {

    public PartnerNotFoundException(String message) {
        super(message);
    }

    public PartnerNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
