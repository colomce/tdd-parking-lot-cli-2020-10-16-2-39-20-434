package com.oocl.cultivation.abilities;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingTicket;

public interface ICanFetch {
    Car fetch(ParkingTicket parkingTicket);
}
