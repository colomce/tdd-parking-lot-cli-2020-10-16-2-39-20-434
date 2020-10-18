package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;

public interface IParkingBehavior {
    ParkingTicket park(Car car);
}
