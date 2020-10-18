package com.oocl.cultivation;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class SuperSmartParkingBehavior implements IParkingBehavior {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot highestPositionRateParkingLot = Collections.max(parkingLots, comparing(ParkingLot::getPositionRate));
        return highestPositionRateParkingLot.park(car);
    }
}
