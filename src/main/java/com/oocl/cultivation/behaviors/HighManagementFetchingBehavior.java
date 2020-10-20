package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLotEmployee;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;
import java.util.Optional;

import static com.oocl.cultivation.constants.ParkingLotConstants.PROVIDE_YOUR_TICKET_MSG;
import static com.oocl.cultivation.constants.ParkingLotConstants.UNRECOGNIZED_PARKING_TICKET_MSG;
import static java.util.Objects.isNull;

public class HighManagementFetchingBehavior implements IFetchingBehavior {
    private List<ParkingLotEmployee> managementList;

    public HighManagementFetchingBehavior(List<ParkingLotEmployee> managementList) {
        this.managementList = managementList;
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        if (isNull(parkingTicket)) {
            throw new InvalidParkingTicketException(PROVIDE_YOUR_TICKET_MSG);
        }
        Optional<ParkingLotEmployee> parkingLotEmployee = managementList.stream()
                .filter(parkingBoy -> parkingBoy.isTicketValid(parkingTicket))
                .findFirst();

        return parkingLotEmployee
                .map(lotEmployee -> lotEmployee.fetch(parkingTicket))
                .orElseThrow(() -> new InvalidParkingTicketException(UNRECOGNIZED_PARKING_TICKET_MSG));
    }
}
