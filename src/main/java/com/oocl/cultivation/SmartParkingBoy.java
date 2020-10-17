package com.oocl.cultivation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;
    private SmartParkingBehavior smartParkingBehavior;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        smartParkingBehavior = new SmartParkingBehavior(parkingLots);
    }

    public ParkingTicket park(Car car) {
        return smartParkingBehavior.park(car);
    }
}
