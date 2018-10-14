package com.oop.parkinglot;

import java.util.List;

public class CompactVehicleParkingService extends ParkingService {

    private static CompactVehicleParkingService compactVehicleParkingService;


    private CompactVehicleParkingService(){}

    public static CompactVehicleParkingService getInstance(){
        if(compactVehicleParkingService == null){
            compactVehicleParkingService = new CompactVehicleParkingService();
        }
        return compactVehicleParkingService;
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
            for(int j=0;j<level.getRows().size();j++) {
                Row row = level.getRows().get(j);
                if (row.getType() == TYPE.COMPACT || row.getType() == TYPE.LARGE) {
                    for (int k = 0; k < row.getSpots().size(); k++) {
                        if (row.getSpots().get(k).isFree()) {
                            return new ParkingInfo(i, j, k, 1);
                        }
                    }
                }
            }
        }
        return null;
    }




}
