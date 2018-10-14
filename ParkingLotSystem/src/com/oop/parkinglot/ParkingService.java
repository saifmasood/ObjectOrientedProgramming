package com.oop.parkinglot;

import java.util.List;

public abstract class ParkingService {

    public abstract boolean park(List<Level> levels,Vehicle vehicle);

    public boolean unpark(List<Level> levels,Vehicle vehicle){
        if(vehicle.parkingInfo == null)
            return false;
        setSpotStatus(levels,true,vehicle.getParkingInfo());
        vehicle.setParkingInfo(null);
        return true;
    }

    protected void setSpotStatus(List<Level> levels,boolean status,ParkingInfo info){
        for(int i=0;i<info.getNumSpots();i++) {
            levels.get(info.getLevelNum())
                    .getRows().get(info.getRowNum())
                    .getSpots().get(info.getStartSpot() + i)
                    .setIsFree(status);
        }
    }
}
