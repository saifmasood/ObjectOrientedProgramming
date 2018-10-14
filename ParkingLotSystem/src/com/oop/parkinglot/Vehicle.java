package com.oop.parkinglot;

public abstract class Vehicle {
    protected String numberPlate;
    protected VEHICLETYPE type;
    protected ParkingInfo parkingInfo;

    public void setParkingInfo(ParkingInfo parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public String getNumberPlate(){
        return numberPlate;
    }

    public VEHICLETYPE getType(){
        return type;
    }

    public ParkingInfo getParkingInfo(){
        return parkingInfo;
    }
}
