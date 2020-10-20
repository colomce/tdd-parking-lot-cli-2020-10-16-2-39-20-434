package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.SuperSmartParkingBehavior;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingLotEmployee {
    private SuperSmartParkingBehavior superSmartParkingBehavior;
    private FetchingBehavior fetchingBehavior;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.superSmartParkingBehavior = new SuperSmartParkingBehavior(this.parkingLots);
        this.fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        this.superSmartParkingBehavior = new SuperSmartParkingBehavior(this.parkingLots);
        this.fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return this.superSmartParkingBehavior.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return fetchingBehavior.fetch(parkingTicket);
    }
}
