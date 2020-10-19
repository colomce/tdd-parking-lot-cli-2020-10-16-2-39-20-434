package com.oocl.cultivation.models;

import com.oocl.cultivation.behaviors.FetchingBehavior;
import com.oocl.cultivation.behaviors.HighManagementFetchingBehavior;
import com.oocl.cultivation.behaviors.HighManagementParkingBehavior;
import com.oocl.cultivation.behaviors.NormalParkingBehavior;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingLotEmployee {
    private FetchingBehavior fetchingBehavior;
    private HighManagementFetchingBehavior highManagementFetchingBehavior;
    private NormalParkingBehavior normalParkingBehavior;
    private List<ParkingLotEmployee> managementList;

    public ServiceManager(ParkingLot parkingLot) {
        super(parkingLot);
        managementList = new ArrayList<>();
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        managementList = new ArrayList<>();
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
    }

    public ServiceManager(List<ParkingLot> parkingLots, List<ParkingLotEmployee> managementList) {
        super(parkingLots);
        this.managementList = managementList;
        fetchingBehavior = new FetchingBehavior(this.parkingLots);
        normalParkingBehavior = new NormalParkingBehavior(this.parkingLots);
        highManagementFetchingBehavior = new HighManagementFetchingBehavior(this.managementList);
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
        HighManagementParkingBehavior highManagementParkingBehavior = new HighManagementParkingBehavior(managementList, parkingLot);
        return highManagementParkingBehavior.park(car);
    }

    public Car delegateFetch(ParkingTicket parkingTicket) {
        return highManagementFetchingBehavior.fetch(parkingTicket);
    }
}
