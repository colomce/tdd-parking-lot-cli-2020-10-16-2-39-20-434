package com.oocl.cultivation.models;

import com.oocl.cultivation.exceptions.NotEnoughPositionException;

import java.util.concurrent.ConcurrentHashMap;

import static com.oocl.cultivation.constants.ParkingLotConstants.NOT_ENOUGH_POSITION_MSG;

public class ParkingLot {
    private int capacity;
    private ConcurrentHashMap<ParkingTicket, Car> parkingSpace = new ConcurrentHashMap<>();

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
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION_MSG);
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

    public int getNumberOfParkedCars() {
        return parkingSpace.size();
    }

    public double getPositionRate() {
        return (double) getAvailableCapacity() / (double) getCapacity();
    }
}
