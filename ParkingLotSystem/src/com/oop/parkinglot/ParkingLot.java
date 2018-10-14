package com.oop.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private ParkingService parkingService;

    private final int NUM_LEVELS = 3;
    private List<Level> levels;

    public ParkingLot(){
        levels = new ArrayList<>();
        initLevels();
    }

    private void initLevels(){
        for(int i=0;i<NUM_LEVELS;i++){
            levels.add(new Level(3));
            levels.get(i).addRow(new Row(10,TYPE.LARGE));
            levels.get(i).addRow(new Row(10,TYPE.COMPACT));
            levels.get(i).addRow(new Row(10,TYPE.SMALL));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        parkingService = ParkingServiceFactory.getParkingService(vehicle.type);
        if(parkingService.park(levels,vehicle)){
            System.out.println("Vehicle with number " + vehicle.numberPlate + " parked");
        }else {
            System.out.println("No space found for vehicle " + vehicle.numberPlate);
        }
        return true;
    }


    public boolean unparkVehicle(Vehicle vehicle){
        if(parkingService.unpark(levels,vehicle)){
            System.out.println("Vehicle with number " + vehicle.numberPlate + "unparked");
        }else {
            System.out.println("No vehicle found with number " + vehicle.numberPlate);
        }
        return true;
    }


}
