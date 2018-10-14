package com.oop.parkinglot;

public class ParkingInfo  {
    private int startSpot;
    private int numSpots;
    private int levelNum;
    private int rowNum;


    public int getStartSpot() {
        return startSpot;
    }

    public int getNumSpots() {
        return numSpots;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public ParkingInfo(int levelNum, int rowNum, int startSpot, int numSpots) {
        this.startSpot = startSpot;
        this.numSpots = numSpots;
        this.levelNum = levelNum;
        this.rowNum = rowNum;
    }
}
