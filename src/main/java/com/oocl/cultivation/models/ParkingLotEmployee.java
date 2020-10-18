package com.oocl.cultivation.models;

abstract class ParkingLotEmployee {
    abstract ParkingTicket park(Car car);
    abstract Car fetch(ParkingTicket parkingTicket);
}
