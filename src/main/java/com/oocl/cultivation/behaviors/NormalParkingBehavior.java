package com.oocl.cultivation.behaviors;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;

import java.util.List;

public class NormalParkingBehavior implements IParkingBehavior {

    private List<ParkingLot> parkingLots;

    public NormalParkingBehavior(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
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
}
