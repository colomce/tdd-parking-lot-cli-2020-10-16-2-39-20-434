package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.NormalParkingBehavior;

import java.util.List;

import static java.util.Collections.singletonList;

public class ParkingBoy extends ParkingLotEmployee {
    private FetchingBehavior fetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = singletonList(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ParkingTicket park(Car car) {
        return normalParkingBehavior.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return this.fetchingBehavior.fetch(parkingTicket);
    }
}
