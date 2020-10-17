package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {
    @Test
    void should_return_parking_lot_when_parking_boy_is_created_given_parking_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingLot parkingLot = parkingBoy.getParkingLot();

        //then
        assertNotNull(parkingLot);
        assertEquals(ParkingLot.class, parkingLot.getClass());
    }

    @Test
    void should_return_parking_ticket_when_parking_boy_park_a_car_given_parking_boy_and_a_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }
}
