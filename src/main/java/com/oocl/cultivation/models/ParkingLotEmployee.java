package com.oocl.cultivation.models;

import java.util.List;

import static java.util.Collections.singletonList;

public abstract class ParkingLotEmployee {
    protected List<ParkingLot> parkingLots;

    ParkingLotEmployee(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    ParkingLotEmployee(ParkingLot parkingLot) {
        this.parkingLots = singletonList(parkingLot);
    }

    public abstract ParkingTicket park(Car car);

    public abstract Car fetch(ParkingTicket parkingTicket);

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
