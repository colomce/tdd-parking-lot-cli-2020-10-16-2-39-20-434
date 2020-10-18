package com.oocl.cultivation;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;
import com.oocl.cultivation.models.ServiceManager;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ServiceManagerTest {
    @Test
    void should_return_cars_when_manager_parking_boy_fetch_given_two_tickets_from_two_parked_cars() {
        //given
        ServiceManager serviceManager = new ServiceManager(new ParkingLot());
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstParkingTicket = serviceManager.park(firstCar);
        ParkingTicket secondParkingTicket = serviceManager.park(secondCar);

        //when
        Car fetchedFirstCar = serviceManager.fetch(firstParkingTicket);
        Car fetchedSecondCar = serviceManager.fetch(secondParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }

    @Test
    void should_fetch_two_right_cars_when_manager_parking_boy_fetch_given_two_parked_cars_two_parking_lot_and_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        ServiceManager serviceManager = new ServiceManager(parkingLots);
        ParkingTicket firstCarParkingTicket = serviceManager.park(firstCar);
        ParkingTicket secondCarParkingTicket = serviceManager.park(secondCar);

        //when
        Car fetchedFirstCar = serviceManager.fetch(firstCarParkingTicket);
        Car fetchedSecondCar = serviceManager.fetch(secondCarParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }

}
