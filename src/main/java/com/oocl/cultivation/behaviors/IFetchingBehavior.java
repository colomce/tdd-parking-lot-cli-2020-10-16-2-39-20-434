package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;

public interface IFetchingBehavior {
    Car fetch(ParkingTicket parkingTicket);
}
