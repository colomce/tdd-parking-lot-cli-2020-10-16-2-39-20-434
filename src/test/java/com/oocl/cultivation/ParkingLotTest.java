package com.oocl.cultivation;

import com.oocl.cultivation.models.ParkingBoy;
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

    @Test
    void should_return_two_when_parking_lot_get_number_of_parked_cars_given_two_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        //then
        assertEquals(2, parkingLot.getNumberOfParkedCars());
    }
    
    @Test
    void should_return_position_rate_zero_point_5_when_parking_lot_get_position_rate_given_parking_lot_with_2_parked_cars_and_4_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(4);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        //then
        assertEquals(0.5, parkingLot.getPositionRate());
    }
}
