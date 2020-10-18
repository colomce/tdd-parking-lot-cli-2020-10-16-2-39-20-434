package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy {
    private SuperSmartParkingBehavior superSmartParkingBehavior;
    private FetchingBehavior fetchingBehavior;
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.superSmartParkingBehavior = new SuperSmartParkingBehavior(this.parkingLots);
        this.fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    public ParkingTicket park(Car car) {
        return this.superSmartParkingBehavior.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetchingBehavior.fetch(parkingTicket);
    }
}
