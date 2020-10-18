package com.oocl.cultivation;

abstract class ParkingLotEmployee {
    abstract ParkingTicket park(Car car);
    abstract Car fetch(ParkingTicket parkingTicket);
}
