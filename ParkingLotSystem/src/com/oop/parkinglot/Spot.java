package com.oop.parkinglot;

public class Spot {
    private boolean isFree;

    public Spot(){
        isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean free) {
        isFree = free;
    }
}
