package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.HighManagementFetchingBehavior;
import com.oocl.cultivation.behaviors.HighManagementParkingBehavior;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingLotEmployee {
    private HighManagementFetchingBehavior highManagementFetchingBehavior;
    private List<ParkingLotEmployee> managementList;

    public ServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        managementList = new ArrayList<>();
        highManagementFetchingBehavior = new HighManagementFetchingBehavior(this.managementList);
    }

    public ServiceManager() {
        managementList = new ArrayList<>();
        highManagementFetchingBehavior = new HighManagementFetchingBehavior(this.managementList);
    }

    @Override
    public ParkingTicket park(Car car) {
        HighManagementParkingBehavior highManagementParkingBehavior = new HighManagementParkingBehavior(managementList);
        return highManagementParkingBehavior.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return highManagementFetchingBehavior.fetch(parkingTicket);
    }

    public List<ParkingLotEmployee> getManagementList() {
        return managementList;
    }

    public void addToManagementList(ParkingLotEmployee parkingLotEmployee) {
        this.managementList.add(parkingLotEmployee);
    }
}
