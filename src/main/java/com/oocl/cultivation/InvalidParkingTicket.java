package com.oocl.cultivation;

public class InvalidParkingTicket extends RuntimeException {
    public InvalidParkingTicket(String message) {
        super(message);
    }
}
