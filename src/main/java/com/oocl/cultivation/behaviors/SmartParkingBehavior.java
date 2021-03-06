package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class SmartParkingBehavior implements IParkingBehavior {

    private List<ParkingLot> parkingLots;

    public SmartParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot highestAvailableSpaceParkingLot = Collections.max(parkingLots, comparing(ParkingLot::getAvailableCapacity));
        return highestAvailableSpaceParkingLot.park(car);
    }
}
