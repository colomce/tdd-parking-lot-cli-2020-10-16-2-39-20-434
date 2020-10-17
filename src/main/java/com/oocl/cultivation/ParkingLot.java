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
        parkingSpace.put(new ParkingTicket(), null);
        return new ParkingTicket();
    }

    public int getAvailableCapacity() {
        return capacity - parkingSpace.size();
    }
}
