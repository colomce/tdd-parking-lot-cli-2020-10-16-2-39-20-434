package com.oocl.cultivation.models;

import com.oocl.cultivation.exceptions.NotEnoughPositionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (getAvailableCapacity() > 0) {
            parkingSpace.put(parkingTicket, car);
            return parkingTicket;
        } else {
            throw new NotEnoughPositionException("Not enough position");
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkingSpace.get(parkingTicket);
        parkingSpace.remove(parkingTicket);
        return car;
    }

    public int getAvailableCapacity() {
        return capacity - parkingSpace.size();
    }

    public boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingSpace.get(parkingTicket) != null;
    }

    List<ParkingTicket> getParkingTickets() {
        return new ArrayList<>(parkingSpace.keySet());
    }

    public int getNumberOfParkedCars() {
        return parkingSpace.size();
    }

    public double getPositionRate() {
        return (double) getAvailableCapacity() / (double) getCapacity();
    }
}