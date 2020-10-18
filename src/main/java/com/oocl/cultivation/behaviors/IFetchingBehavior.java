package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingTicket;

public interface IFetchingBehavior {
    Car fetch(ParkingTicket parkingTicket);
}
