package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.NormalParkingBehavior;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ServiceManager extends ParkingLotEmployee {
    private FetchingBehavior fetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;
    private List<ParkingLotEmployee> managementList;

    public ServiceManager(ParkingLot parkingLot) {
        super(parkingLot);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ServiceManager(ParkingLotEmployee... managementList) {
        this.managementList = asList(managementList);
    }

    @Override
    public ParkingTicket park(Car car) {
        return normalParkingBehavior.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return fetchingBehavior.fetch(parkingTicket);
    }

    public List<ParkingLotEmployee> getManagementList() {
        return managementList;
    }

    public ParkingTicket delegateParking(Car car, ParkingLot parkingLot) {
        Optional<ParkingLotEmployee> parkingLotEmployee = managementList.stream()
                .filter(parkingBoy -> parkingBoy.getParkingLots().contains(parkingLot))
                .findFirst();
        return parkingLotEmployee.map(lotEmployee -> lotEmployee.park(car)).orElse(null);
    }

    public Car delegateFetch(ParkingTicket parkingTicket) {
        Optional<ParkingLotEmployee> parkingLotEmployee = managementList.stream()
                .filter(parkingBoy -> parkingBoy.getParkingLots().stream()
                        .anyMatch(parkingLot -> parkingLot.isTicketValid(parkingTicket)))
                .findFirst();
        return parkingLotEmployee.map(lotEmployee -> lotEmployee.fetch(parkingTicket))
                .orElse(null);
    }
}
