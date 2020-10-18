package com.oocl.cultivation.models;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;

abstract class ParkingLotEmployee {
    abstract ParkingTicket park(Car car);
    abstract Car fetch(ParkingTicket parkingTicket);
}
