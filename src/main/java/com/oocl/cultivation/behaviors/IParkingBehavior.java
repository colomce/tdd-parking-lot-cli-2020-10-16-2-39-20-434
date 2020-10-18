package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingTicket;

public interface IParkingBehavior {
    ParkingTicket park(Car car);
}
