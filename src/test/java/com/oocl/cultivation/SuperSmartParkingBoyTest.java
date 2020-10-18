package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void should_first_parking_lot_have_11_parked_car_and_return_ticket_when_super_smart_parking_boy_parked_a_car_given_first_parking_lot_with_15_capacity_and_10_car_and_second_parking_lot_with_20_capacity_and_18_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(15);
        ParkingLot secondParkingLot = new ParkingLot(20);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        parkMultipleTimes(superSmartParkingBoy, 28);

        //then
        assertEquals(12, firstParkingLot.getNumberOfParkedCars());
        assertEquals(16, secondParkingLot.getNumberOfParkedCars());
    }

    void parkMultipleTimes(SuperSmartParkingBoy superSmartParkingBoy, int noOfCars) {
        for (int i = 1; i <= noOfCars; i++) {
            superSmartParkingBoy.park(new Car());
        }
    }
}
