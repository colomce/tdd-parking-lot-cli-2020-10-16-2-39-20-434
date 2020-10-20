package com.oocl.cultivation.models;

import com.oocl.cultivation.abilities.ICanFetch;
import com.oocl.cultivation.abilities.ICanPark;

import java.util.List;

import static java.util.Collections.singletonList;

public abstract class ParkingLotEmployee implements ICanPark, ICanFetch {
    protected List<ParkingLot> parkingLots;

    ParkingLotEmployee(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    ParkingLotEmployee(ParkingLot parkingLot) {
        this.parkingLots = singletonList(parkingLot);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
