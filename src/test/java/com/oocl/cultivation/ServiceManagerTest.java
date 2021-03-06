package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.InvalidParkingTicketException;
import com.oocl.cultivation.exceptions.NotEnoughPositionException;
import com.oocl.cultivation.models.Car;
import com.oocl.cultivation.models.ParkingBoy;
import com.oocl.cultivation.models.ParkingLot;
import com.oocl.cultivation.models.ParkingTicket;
import com.oocl.cultivation.models.ServiceManager;
import com.oocl.cultivation.models.SmartParkingBoy;
import com.oocl.cultivation.models.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceManagerTest {
    @Test
    void should_return_cars_when_manager_parking_boy_fetch_given_two_tickets_from_two_parked_cars() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(parkingBoy);
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
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);

        ParkingTicket firstCarParkingTicket = serviceManager.park(firstCar);
        ParkingTicket secondCarParkingTicket = serviceManager.park(secondCar);

        //when
        Car fetchedFirstCar = serviceManager.fetch(firstCarParkingTicket);
        Car fetchedSecondCar = serviceManager.fetch(secondCarParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }

    @Test
    void should_return_three_parking_boys_when_manager_get_list_of_parking_boy_given_3_different_parking_boys_with_parking_lots_1_capacity() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);

        ServiceManager serviceManager = new ServiceManager(Collections.emptyList());
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);
        serviceManager.addToManagementList(superSmartParkingBoy);
        //when

        //then
        assertNotNull(serviceManager.getManagementList());
        assertEquals(3, serviceManager.getManagementList().size());
    }

    @Test
    void should_be_able_to_park_all_cars_in_different_parking_lot_when_manager_delegate_parking_a_car_given_3_different_parking_boys_with_parking_lots_1_capacity() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);

        ServiceManager serviceManager = new ServiceManager(Collections.emptyList());
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);
        serviceManager.addToManagementList(superSmartParkingBoy);
        //when
        ParkingTicket firstParkingTicket = serviceManager.park(firstCar);
        ParkingTicket secondParkingTicket = serviceManager.park(secondCar);
        ParkingTicket thirdParkingTicket = serviceManager.park(thirdCar);

        Car fetchedFirstCar = serviceManager.fetch(firstParkingTicket);
        Car fetchedSecondCar = serviceManager.fetch(secondParkingTicket);
        Car fetchedThirdCar = serviceManager.fetch(thirdParkingTicket);

        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
        assertSame(thirdCar, fetchedThirdCar);
    }

    @Test
    void should_throw_NotEnoughPosition_with_message_Not_enough_position_when_service_manager_delegate_three_different_parking_boy_to_park_a_car_given_three_different_parking_boy_with_one_parking_lot_each_that_fully_parked() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        Car fourthCar = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);

        ServiceManager serviceManager = new ServiceManager(Collections.emptyList());
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);
        serviceManager.addToManagementList(superSmartParkingBoy);
        ParkingTicket firstParkingTicket = serviceManager.park(firstCar);
        ParkingTicket secondParkingTicket = serviceManager.park(secondCar);
        ParkingTicket thirdParkingTicket = serviceManager.park(thirdCar);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> serviceManager.park(fourthCar));

        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());

        Car fetchedFirstCar = serviceManager.fetch(firstParkingTicket);
        Car fetchedSecondCar = serviceManager.fetch(secondParkingTicket);
        Car fetchedThirdCar = serviceManager.fetch(thirdParkingTicket);

        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
        assertSame(thirdCar, fetchedThirdCar);
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_service_manager_delegate_fetch_parking_boy_to_parked_a_car_given_invalid_parking_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);

        ServiceManager serviceManager = new ServiceManager(Collections.emptyList());
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);
        serviceManager.addToManagementList(superSmartParkingBoy);

        serviceManager.park(firstCar);
        serviceManager.park(secondCar);
        serviceManager.park(thirdCar);

        //when
        InvalidParkingTicketException invalidParkingTicketException = assertThrows(InvalidParkingTicketException.class, () -> serviceManager.fetch(null));

        //then
        assertEquals("Please provide your parking ticket", invalidParkingTicketException.getMessage());
    }

    @Test
    void should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_service_manager_delegate_fetch_parking_boy_to_parked_a_car_given_wrong_parking_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);

        ServiceManager serviceManager = new ServiceManager(Collections.emptyList());
        serviceManager.addToManagementList(parkingBoy);
        serviceManager.addToManagementList(smartParkingBoy);
        serviceManager.addToManagementList(superSmartParkingBoy);

        serviceManager.park(firstCar);
        serviceManager.park(secondCar);
        serviceManager.park(thirdCar);

        //when
        InvalidParkingTicketException invalidParkingTicketException =
                assertThrows(InvalidParkingTicketException.class,
                        () -> serviceManager.fetch(new ParkingTicket()));

        //then
        assertEquals("Unrecognized parking ticket", invalidParkingTicketException.getMessage());
    }
}
