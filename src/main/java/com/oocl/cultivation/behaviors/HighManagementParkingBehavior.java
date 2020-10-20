package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingLotEmployee;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;
import java.util.Optional;

public class HighManagementParkingBehavior implements IParkingBehavior {

    private final List<ParkingLotEmployee> managementList;
    private final ParkingLot parkingLot;

    public HighManagementParkingBehavior(List<ParkingLotEmployee> managementList, ParkingLot parkingLot) {
        this.managementList = managementList;
        this.parkingLot = parkingLot;
    }

    @Override
    public ParkingTicket park(Car car) {
        Optional<ParkingLotEmployee> parkingLotEmployee = managementList.stream()
                .filter(parkingBoy -> parkingBoy.manages(parkingLot))
                .findFirst();
        return parkingLotEmployee.map(lotEmployee -> lotEmployee.park(car)).orElse(null);
    }
}
