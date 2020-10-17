package com.oocl.cultivation;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        if(!parkingLots.isEmpty()) {
            for (ParkingLot parkingLot : parkingLots) {
                if(parkingLot.getAvailableCapacity() > 0) {
                    return parkingLot.park(car);
                }
            }
        }
        return parkingLots.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots.get(0).fetch(parkingTicket);
    }

    public boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingLots.get(0).isTicketValid(parkingTicket);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
