package com.oop.parkinglot;


public class Motorcycle extends Vehicle {

    public Motorcycle(String numberPlate){
        type = VEHICLETYPE.SMALL;
        this.numberPlate = numberPlate;
    }

}