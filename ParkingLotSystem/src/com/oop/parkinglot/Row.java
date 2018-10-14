package com.oop.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private TYPE type;
    private List<Spot> spots;

    public Row(int size,TYPE type){
        this.type = type;
        spots = new ArrayList<>();
        int numSpots = size / type.getUnits();
        for(int i=0;i<numSpots;i++)
            spots.add(new Spot());
    }

    public List<Spot> getSpots(){
        return spots;
    }

    public TYPE getType(){
        return type;
    }



}
