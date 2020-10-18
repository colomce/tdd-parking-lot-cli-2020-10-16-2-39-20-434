package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.SmartParkingBehavior;

import java.util.List;

public class SmartParkingBoy extends ParkingLotEmployee {
    private SmartParkingBehavior smartParkingBehavior;
    private FetchingBehavior fetchingBehavior;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        smartParkingBehavior = new SmartParkingBehavior(parkingLots);
        fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        smartParkingBehavior = new SmartParkingBehavior(parkingLots);
        fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    public ParkingTicket park(Car car) {
        return smartParkingBehavior.park(car);
    }

    public Car fetch(ParkingTicket firstParkingTicket) {
        return fetchingBehavior.fetch(firstParkingTicket);
    }
}
