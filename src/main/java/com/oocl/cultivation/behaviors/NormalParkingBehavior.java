package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;
import java.util.Optional;

import static com.oocl.cultivation.constants.ParkingLotConstants.NOT_ENOUGH_POSITION_MSG;

public class NormalParkingBehavior implements IParkingBehavior {

    private List<ParkingLot> parkingLots;

    public NormalParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream()
                .filter(parking -> parking.getAvailableCapacity() > 0)
                .findFirst();

        return optionalParkingLot
                .map(parkingLot -> parkingLot.park(car))
                .orElseThrow(() -> new NotEnoughPositionException(NOT_ENOUGH_POSITION_MSG));
    }
}
