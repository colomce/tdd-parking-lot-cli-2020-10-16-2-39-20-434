package com.oocl.cultivation.exceptions;

public class InvalidParkingTicketException extends RuntimeException {
    public InvalidParkingTicketException(String message) {
        super(message);
    }
}
