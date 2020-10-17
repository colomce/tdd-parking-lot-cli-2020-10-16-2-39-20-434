package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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

    @Test
    void should_return_parking_lot_with_remaining_capacity_9_when_parking_boy_parked_a_car_given_parking_lot_with_capacity_10() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        assertEquals(9, parkingLot.getAvailableCapacity());
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_a_car_given_parking_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertSame(car, fetchedCar);
    }

    @Test
    void should_return_cars_when_parking_boy_fetch_given_two_tickets_from_two_parked_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstParkingTicket = parkingBoy.park(firstCar);
        ParkingTicket secondParkingTicket = parkingBoy.park(secondCar);

        //when
        Car fetchedFirstCar = parkingBoy.fetch(firstParkingTicket);
        Car fetchedSecondCar = parkingBoy.fetch(secondParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }

    @Test
    void should_return_no_Car_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        ParkingTicket correctParkingTicket = parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();

        //when
        Car fetchedCar = parkingBoy.fetch(wrongTicket);
        boolean isValidTicket = parkingBoy.isTicketValid(wrongTicket);

        //then
        assertNull(fetchedCar);
        assertFalse(isValidTicket);
    }

    @Test
    void should_return_no_Car_when_fetch_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Car fetchedCar = parkingBoy.fetch(null);

        //then
        assertNull(fetchedCar);
    }
}
