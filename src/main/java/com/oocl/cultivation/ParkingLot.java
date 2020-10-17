package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

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
        if (getAvailableCapacity() > 0) {
            parkingSpace.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    Car fetch(ParkingTicket parkingTicket) {
        if (!isTicketValid(parkingTicket)) {
            throw new InvalidParkingTicket("Unrecognized parking ticket");
        }
        Car car = isNull(parkingTicket) ? null : parkingSpace.get(parkingTicket);
        parkingSpace.remove(parkingTicket);
        return car;
    }

    public int getAvailableCapacity() {
        return capacity - parkingSpace.size();
    }

    boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingSpace.get(parkingTicket) != null;
    }
}
