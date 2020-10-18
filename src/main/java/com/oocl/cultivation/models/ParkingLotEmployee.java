package com.oocl.cultivation.models;

import java.util.List;

import static java.util.Arrays.asList;

public abstract class ParkingLotEmployee {
    public List<ParkingLot> parkingLots;

    public ParkingLotEmployee(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingLotEmployee(ParkingLot parkingLot) {
        this.parkingLots = asList(parkingLot);
    }

    protected ParkingLotEmployee() {
    }

    public abstract ParkingTicket park(Car car);

    public abstract Car fetch(ParkingTicket parkingTicket);

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
