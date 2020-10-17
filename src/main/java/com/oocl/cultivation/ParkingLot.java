package com.oocl.cultivation;

public class ParkingLot {
    private int capacity;

    public ParkingLot() {
        capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public ParkingTicket park(Car car) {
        return new ParkingTicket();
    }
}
