package com.oocl.cultivation;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class SmartParkingBehavior implements IParkingBehavior {

    private List<ParkingLot> parkingLots;

    SmartParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot highestAvailableSpaceParkingLot = Collections.max(parkingLots, comparing(ParkingLot::getAvailableCapacity));
        return highestAvailableSpaceParkingLot.park(car);
    }
}
