package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLotEmployee;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;

import static com.oocl.cultivation.constants.ParkingLotConstants.NOT_ENOUGH_POSITION_MSG;

public class HighManagementParkingBehavior implements IParkingBehavior {

    private final List<ParkingLotEmployee> managementList;

    public HighManagementParkingBehavior(List<ParkingLotEmployee> managementList) {
        this.managementList = managementList;
    }

    @Override
    public ParkingTicket park(Car car) {
        return managementList.stream()
                .filter(parkingBoy -> !parkingBoy.isFull())
                .findFirst()
                .orElseThrow(() -> new NotEnoughPositionException(NOT_ENOUGH_POSITION_MSG))
                .park(car);

    }
}
