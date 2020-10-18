package com.oocl.cultivation.models;

public class ServiceManager extends ParkingLotEmployee {
    public ServiceManager(ParkingLot parkingLot) {
    }

    @Override
    public ParkingTicket park(Car car) {
        return null;
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return null;
    }
}
