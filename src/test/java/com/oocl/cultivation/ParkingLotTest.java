package com.oocl.cultivation;

import com.sun.webkit.PageCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    public void should_return_capacity_10_when_parking_lot_is_created_given_no_capacity() {
        ParkingLot parkingLot = new ParkingLot();
        Assertions.assertEquals(10 , parkingLot.getCapacity());
    }
}
