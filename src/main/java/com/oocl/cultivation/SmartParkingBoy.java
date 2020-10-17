package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;
    private SmartParkingBehavior smartParkingBehavior;
    private FetchingBehavior fetchingBehavior;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
