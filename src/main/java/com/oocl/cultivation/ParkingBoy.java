package com.oocl.cultivation;

import java.util.List;

import static java.util.Arrays.asList;

public class ParkingBoy extends ParkingLotEmployee {

    private FetchingBehavior fetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = asList(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ParkingTicket park(Car car) {
        return normalParkingBehavior.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return this.fetchingBehavior.fetch(parkingTicket);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
