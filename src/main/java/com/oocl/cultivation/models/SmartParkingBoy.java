package com.oocl.cultivation.models;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.FetchingBehavior;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.SmartParkingBehavior;

import java.util.List;

public class SmartParkingBoy extends ParkingLotEmployee {
    private List<ParkingLot> parkingLots;
    private SmartParkingBehavior smartParkingBehavior;
    private FetchingBehavior fetchingBehavior;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        smartParkingBehavior = new SmartParkingBehavior(parkingLots);
        fetchingBehavior = new FetchingBehavior(parkingLots);
    }

    public ParkingTicket park(Car car) {
        return smartParkingBehavior.park(car);
    }

    public Car fetch(ParkingTicket firstParkingTicket) {
        return fetchingBehavior.fetch(firstParkingTicket);
    }
}
