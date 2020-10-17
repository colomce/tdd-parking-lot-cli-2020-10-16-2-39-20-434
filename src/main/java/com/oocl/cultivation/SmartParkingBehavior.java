package com.oocl.cultivation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBehavior implements IParkingBehavior {

    private List<ParkingLot> parkingLots;

    SmartParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot highestAvailableSpaceParkingLot = Collections.max(parkingLots, Comparator.comparing(ParkingLot::getAvailableCapacity));
        return highestAvailableSpaceParkingLot.park(car);
    }
}
