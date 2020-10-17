package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    @Test
    void should_return_capacity_10_when_parking_lot_is_created_given_no_capacity() {
        ParkingLot parkingLot = new ParkingLot();
        assertEquals(10, parkingLot.getCapacity());
    }

    @Test
    void should_return_capacity_5_when_parking_lot_is_created_given_capacity_5() {
        ParkingLot parkingLot = new ParkingLot(5);
        assertEquals(5, parkingLot.getCapacity());
    }
}
