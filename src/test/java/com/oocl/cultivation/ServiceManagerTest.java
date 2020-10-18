package com.oocl.cultivation;

import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;
import com.oocl.cultivation.models.ServiceManager;
import org.junit.jupiter.api.Test;

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

}
