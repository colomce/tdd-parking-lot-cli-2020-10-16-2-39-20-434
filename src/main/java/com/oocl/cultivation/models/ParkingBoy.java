package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.NormalParkingBehavior;

import java.util.List;

public class ParkingBoy extends ParkingLotEmployee {
    private FetchingBehavior fetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;

    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return normalParkingBehavior.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return this.fetchingBehavior.fetch(parkingTicket);
    }
}
