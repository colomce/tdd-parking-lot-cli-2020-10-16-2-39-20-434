package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<ParkingTicket, Car> parkingSpace = new HashMap<>();

    public ParkingLot() {
        capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingSpace.put(parkingTicket, car);
        return parkingTicket;
    }

    Car fetch(ParkingTicket parkingTicket) {
        return parkingTicket == null ? null : parkingSpace.get(parkingTicket);
    }

    public int getAvailableCapacity() {
        return capacity - parkingSpace.size();
    }

    boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingSpace.get(parkingTicket) != null;
    }
}
