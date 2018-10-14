package com.oop.parkinglot;

public class Bus extends Vehicle {
    public Bus(String numberPlate){
        type = VEHICLETYPE.LARGE;
        this.numberPlate = numberPlate;
    }
}
