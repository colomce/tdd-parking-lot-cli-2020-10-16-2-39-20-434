package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_super_mart_parking_boy_parks_a_car_given_parking_lot_with_1_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(parkingLot);
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_two_right_car_when_super_smart_parking_boy_fetch_given_two_parking_lot_with_5_capacity() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingTicket firstParkingTicket = superSmartParkingBoy.park(firstCar);
        ParkingTicket secondParkingTicket = superSmartParkingBoy.park(secondCar);

        //when
        Car fetchedFirstCar = superSmartParkingBoy.fetch(firstParkingTicket);
        Car fetchedSecondCar = superSmartParkingBoy.fetch(secondParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }
}
