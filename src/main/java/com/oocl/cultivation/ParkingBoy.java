package com.oocl.cultivation;

import java.util.List;

import static java.util.Arrays.asList;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = asList(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
        if (parkingTicket == null) {
            throw new InvalidParkingTicketException("Please provide your parking ticket");
        }
        if (!isTicketValid(parkingTicket)) {
            throw new InvalidParkingTicketException("Unrecognized parking ticket");
        }
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isTicketValid(parkingTicket))
                .map(parkingLot -> parkingLot.fetch(parkingTicket)).findFirst()
                .orElse(null);
    }

    public boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isTicketValid(parkingTicket));
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
