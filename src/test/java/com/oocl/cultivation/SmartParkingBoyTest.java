package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartParkingBoyTest {
    @Test
    void should_first_parking_lot_have_one_parked_car_when_smart_parking_boy_park_a_car_given_two_parking_lots_with_no_parked_cars() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(1, firstParkingLot.getParkingTickets().size());
    }

    @Test
    void should_first_parking_lot_have_two_parked_car_when_smart_parking_boy_park_a_car_given_two_parking_lot_with_five_capacity_and_one_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(firstCar);
        smartParkingBoy.park(secondCar);

        //when
        Car thirdCar = new Car();
        smartParkingBoy.park(thirdCar);

        //then
        assertEquals(2, firstParkingLot.getParkingTickets().size());
    }
}
