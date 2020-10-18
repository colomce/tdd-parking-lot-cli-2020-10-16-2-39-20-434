package com.oocl.cultivation.models;

public abstract class ParkingLotEmployee {
    abstract ParkingTicket park(Car car);
    abstract Car fetch(ParkingTicket parkingTicket);
}
