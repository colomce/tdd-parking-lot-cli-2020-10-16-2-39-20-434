package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.constants.Constants;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;

import static com.oocl.cultivation.constants.Constants.UNRECOGNIZED_PARKING_TICKET_MSG;

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
            throw new InvalidParkingTicketException(UNRECOGNIZED_PARKING_TICKET_MSG);
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
