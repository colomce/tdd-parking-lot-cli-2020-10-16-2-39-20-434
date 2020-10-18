package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLotEmployee;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;
import java.util.Optional;

public class HighManagementFetchingBehavior implements IFetchingBehavior {
    private List<ParkingLotEmployee> managementList;

    public HighManagementFetchingBehavior(List<ParkingLotEmployee> managementList) {
        this.managementList = managementList;
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new InvalidParkingTicketException("Please provide your parking ticket");
        }
        Optional<ParkingLotEmployee> parkingLotEmployee = managementList.stream()
                .filter(parkingBoy -> parkingBoy.getParkingLots().stream()
                        .anyMatch(parkingLot -> parkingLot.isTicketValid(parkingTicket)))
                .findFirst();

        return parkingLotEmployee
                .map(lotEmployee -> lotEmployee.fetch(parkingTicket))
                .orElseThrow(() -> new InvalidParkingTicketException("Unrecognized parking ticket"));
    }
}
