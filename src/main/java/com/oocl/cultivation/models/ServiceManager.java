package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.NormalParkingBehavior;

import java.util.List;

import static java.util.Arrays.asList;

public class ServiceManager extends ParkingLotEmployee {
    private FetchingBehavior fetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;
    private List<ParkingLot> parkingLots;

    public ServiceManager(ParkingLot parkingLot) {
        this.parkingLots = asList(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ServiceManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return normalParkingBehavior.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return fetchingBehavior.fetch(parkingTicket);
    }
}
