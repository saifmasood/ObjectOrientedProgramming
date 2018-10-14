package com.oop.parkinglot;

public enum TYPE {
    SMALL(2),COMPACT(5),LARGE(10);
    private int units;

    private TYPE(int units){
        this.units = units;
    }

    public int getUnits(){
        return units;
    }

}
