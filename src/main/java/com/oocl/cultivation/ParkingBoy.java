package com.oocl.cultivation;

import java.util.List;

import static java.util.Arrays.asList;

public class ParkingBoy {

    private FetchingBehavior fetchingBehavior;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = asList(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);

    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
    }

    public ParkingTicket park(Car car) {
        if (!parkingLots.isEmpty()) {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getAvailableCapacity() > 0) {
                    return parkingLot.park(car);
                }
            }
        }
        return parkingLots.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return this.fetchingBehavior.fetch(parkingTicket);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
