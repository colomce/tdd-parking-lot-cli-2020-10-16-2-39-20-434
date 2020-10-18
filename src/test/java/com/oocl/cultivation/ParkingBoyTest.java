package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.ParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {
    @Test
    void should_return_parking_lot_when_parking_boy_is_created_given_parking_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingLot parkingLot = parkingBoy.getParkingLots().get(0);

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
        Car fetchedCar = null;
        try {
            fetchedCar = parkingBoy.fetch(wrongTicket);
        } catch (InvalidParkingTicketException ignored) {

        }

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_no_Car_when_fetch_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Car fetchedCar = null;

        try {
            fetchedCar = parkingBoy.fetch(null);
        } catch (InvalidParkingTicketException ignored) {

        }

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_no_car_when_fetched_two_times_given_a_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);

        //when
        Car fetchedCar = null;

        try {
            fetchedCar = parkingBoy.fetch(parkingTicket);
        } catch (InvalidParkingTicketException ignored) {

        }

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_no_ticket_when_parking_boy_parked_a_car_given_parking_lot_with_1_capacity() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(firstCar);

        //when
        ParkingTicket parkingTicket = null;
        try {
            parkingBoy.park(secondCar);
        } catch (NotEnoughPositionException ignored) {

        }

        //then
        assertNull(parkingTicket);
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_parking_boy_parks_a_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket", invalidParkingTicketException.getMessage());
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_parking_boy_fetch_a_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> parkingBoy.fetch(null));

        //then
        assertEquals("Please provide your parking ticket", invalidParkingTicketException.getMessage());
    }

    @Test
    void should_throw_NotEnoughPosition_with_message_Not_enough_position_when_parking_boy_parked_a_car_given_parking_lot_with_one_capacity_and_a_parked_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(new Car());

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> parkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_return_two_parking_lots_when_parking_boy_get_parking_lots_given_two_parking_lots() {
        //given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(), new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        int numberOfParkingLots = parkingBoy.getParkingLots().size();

        //then
        assertEquals(2, numberOfParkingLots);
    }

    @Test
    void should_second_parking_lot_return_parking_ticket_when_parking_boy_parked_a_car_given_two_parking_lot_where_first_parking_lot_is_full() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(firstCar);

        //when
        ParkingTicket secondParkingTicket = parkingBoy.park(secondCar);

        //then
        assertNotNull(secondParkingTicket);
        assertEquals(0, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_first_parking_lot_return_parking_ticket_when_parking_boy_parked_two_cars_given_two_parking_lot_where_first_parking_lot_capacity_is_two() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(firstCar);

        //when
        ParkingTicket secondParkingTicket = parkingBoy.park(secondCar);

        //then
        assertNotNull(secondParkingTicket);
        assertEquals(0, firstParkingLot.getAvailableCapacity());
    }

    @Test
    void should_third_parking_lot_return_parking_ticket_when_parking_boy_parked_a_car_given_first_and_second_is_full_and_third_parking_lot_is_not() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot, thirdParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(firstCar);
        parkingBoy.park(secondCar);
        //when

        ParkingTicket parkingTicket = parkingBoy.park(thirdCar);

        //then
        assertNotNull(parkingTicket);
        assertEquals(0, firstParkingLot.getAvailableCapacity());
        assertEquals(0, secondParkingLot.getAvailableCapacity());
        assertEquals(0, thirdParkingLot.getAvailableCapacity());
    }

    @Test
    void should_throw_NotEnoughPosition_with_message_Not_enough_position_when_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(firstCar);
        parkingBoy.park(secondCar);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> parkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_parking_boy_parked_a_car_given_two_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(firstCar);
        parkingBoy.park(secondCar);

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> parkingBoy.fetch(null));

        //then
        assertEquals("Please provide your parking ticket", invalidParkingTicketException.getMessage());
    }

    @Test
    void should_fetch_two_right_cars_when_parking_boy_fetch_given_two_parked_cars_and_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket firstCarParkingTicket = parkingBoy.park(firstCar);
        ParkingTicket secondCarParkingTicket = parkingBoy.park(secondCar);

        //when
        Car fetchedFirstCar = parkingBoy.fetch(firstCarParkingTicket);
        Car fetchedSecondCar = parkingBoy.fetch(secondCarParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }
}
