package com.oocl.cultivation.models;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.behaviors.SuperSmartParkingBehavior;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingLotEmployee {
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
