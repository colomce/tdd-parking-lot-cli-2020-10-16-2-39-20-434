package com.oocl.cultivation;

import java.util.List;

public class FetchingBehavior implements IFetchingBehavior {

    private List<ParkingLot> parkingLots;

    public FetchingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
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

    private boolean isTicketValid(ParkingTicket parkingTicket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isTicketValid(parkingTicket));
    }

}
