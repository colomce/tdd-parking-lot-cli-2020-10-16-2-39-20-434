package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {

    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }

    public boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingLot.isTicketValid(parkingTicket);
    }

    public List<ParkingLot> getParkingLots() {
        return null;
    }
}
