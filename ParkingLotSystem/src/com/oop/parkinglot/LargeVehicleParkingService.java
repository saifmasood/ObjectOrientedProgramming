package com.oop.parkinglot;

import java.util.List;

public class LargeVehicleParkingService extends ParkingService{

    private static LargeVehicleParkingService largeVehicleParkingService;


    private LargeVehicleParkingService(){}

    public static LargeVehicleParkingService getInstance(){
        if(largeVehicleParkingService == null){
            largeVehicleParkingService = new LargeVehicleParkingService();
        }
        return largeVehicleParkingService;
    }
    @Override
    public boolean park(List<Level> levels, Vehicle vehicle){
        ParkingInfo info = getParkingSpot(levels);
        if(info == null)
            return false;
        setSpotStatus(levels,false,info);
        vehicle.setParkingInfo(info);
        return true;
    }

    private ParkingInfo getParkingSpot(List<Level> levels){
        for(int i=0;i<levels.size();i++){
            Level level = levels.get(i);
            for(int j=0;j<level.getRows().size();j++){
                Row row = level.getRows().get(j);
                if(row.getType() == TYPE.LARGE){
                    for(int k=0;k<row.getSpots().size();k++){
                        if(row.getSpots().get(k).isFree()){
                            return new ParkingInfo(i,j,k,1);
                        }
                    }
                }else if(row.getType() == TYPE.COMPACT){
                    int spotsRequired = 5;
                    for(int k=0,s=spotsRequired;k<row.getSpots().size();k++){
                        if(row.getSpots().get(k).isFree()){
                            s -= 1;
                        }else {
                            s = spotsRequired;
                        }
                        if(s == 0){
                            return new ParkingInfo(i,j,k-spotsRequired,spotsRequired);
                        }
                    }
                }
            }
        }
        return null;
    }
}
