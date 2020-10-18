package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;
import com.oocl.cultivation.models.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void should_first_parking_lot_have_12_parked_car_and_second_parking_lot_have_16_parked_cars__when_super_smart_parking_boy_parked_a_car_given_first_parking_lot_with_15_capacity_and_10_car_and_second_parking_lot_with_20_capacity_and_18_parked_car() {
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

    @Test
    void should_first_parking_lot_have_5_parked_car_and_second_parking_lot_have_10_parked_cars_when_super_smart_parking_boy_parked_a_car_given_first_parking_lot_with_10_capacity_and_5_car_and_second_parking_lot_with_20_capacity_and_10_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(20);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        parkMultipleTimes(superSmartParkingBoy, 15);

        //then
        assertEquals(5, firstParkingLot.getNumberOfParkedCars());
        assertEquals(10, secondParkingLot.getNumberOfParkedCars());
    }

    @Test
    void should_first_parking_lot_have_16_parked_car_and_second_parking_lot_have_12_parked_cars__when_super_smart_parking_boy_parked_a_car_given_second_parking_lot_with_15_capacity_and_10_car_and_first_parking_lot_with_20_capacity_and_18_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(20);
        ParkingLot secondParkingLot = new ParkingLot(15);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        parkMultipleTimes(superSmartParkingBoy, 28);

        //then
        assertEquals(16, firstParkingLot.getNumberOfParkedCars());
        assertEquals(12, secondParkingLot.getNumberOfParkedCars());
    }

    @Test
    void should_parking_lot_have_15_11_2_parked_cars_when_super_smart_parking_boy_parked_a_car_given_three_parking_lot_with_capacity_20_15_2_and_28_parked_cars() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(20);
        ParkingLot secondParkingLot = new ParkingLot(15);
        ParkingLot thirdParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot, thirdParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        parkMultipleTimes(superSmartParkingBoy, 28);

        //then
        assertEquals(15, firstParkingLot.getNumberOfParkedCars());
        assertEquals(11, secondParkingLot.getNumberOfParkedCars());
        assertEquals(2, thirdParkingLot.getNumberOfParkedCars());
    }

    @Test
    void should_throw_NotEnoughPosition_with_message_Not_enough_position_when_super_smart_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(firstCar);
        superSmartParkingBoy.park(secondCar);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> superSmartParkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_super_smart_parking_boy_parked_a_car_given_two_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
        Car firstCar = new Car();
        Car secondCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(firstCar);
        superSmartParkingBoy.park(secondCar);

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> superSmartParkingBoy.fetch(null));

        //then
        assertEquals("Please provide your parking ticket", invalidParkingTicketException.getMessage());
    }

    void parkMultipleTimes(SuperSmartParkingBoy superSmartParkingBoy, int noOfCars) {
        for (int i = 1; i <= noOfCars; i++) {
            superSmartParkingBoy.park(new Car());
        }
    }
}
