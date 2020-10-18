package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;
import com.oocl.cultivation.models.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartParkingBoyTest {

    @Test
    void should_return_parking_ticket_when_smart_parking_boy_parks_a_car_given_parking_lot_with_1_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(parkingLot);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_two_right_car_when_smart_parking_boy_fetch_given_two_parking_lot_with_5_capacity() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket firstParkingTicket = smartParkingBoy.park(firstCar);
        ParkingTicket secondParkingTicket = smartParkingBoy.park(secondCar);

        //when
        Car fetchedFirstCar = smartParkingBoy.fetch(firstParkingTicket);
        Car fetchedSecondCar = smartParkingBoy.fetch(secondParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }

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
        assertEquals(1, firstParkingLot.getNumberOfParkedCars());
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
        assertEquals(2, firstParkingLot.getNumberOfParkedCars());
    }

    @Test
    void should_second_parking_have_one_parked_car_when_smart_parking_boy_parks_a_car_given_two_parking_lot_where_first_parking_lot_has_more_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        Car fourthCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(firstCar);
        smartParkingBoy.park(secondCar);
        smartParkingBoy.park(thirdCar);

        //when
        smartParkingBoy.park(fourthCar);

        //then
        assertEquals(2, firstParkingLot.getNumberOfParkedCars());
        assertEquals(2, secondParkingLot.getNumberOfParkedCars());
    }

    @Test
    void should_throw_NotEnoughPosition_with_message_Not_enough_position_when_smart_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(firstCar);
        smartParkingBoy.park(secondCar);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> smartParkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_smart_parking_boy_parked_a_car_given_two_parking_lots_and_null_parking_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(firstCar);
        smartParkingBoy.park(secondCar);

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> smartParkingBoy.fetch(null));

        //then
        assertEquals("Please provide your parking ticket", invalidParkingTicketException.getMessage());
    }
    
}
