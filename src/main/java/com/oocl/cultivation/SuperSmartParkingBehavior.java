package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBehavior implements IParkingBehavior {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        return new ParkingTicket();
    }
}
