package com.oop.parkinglot;

public class ParkingServiceFactory {

    public static ParkingService getParkingService(VEHICLETYPE type){
        if(type == VEHICLETYPE.SMALL){
            return SmallVehicleParkingService.getInstance();
        }else if(type == VEHICLETYPE.COMPACT){
            return CompactVehicleParkingService.getInstance();
        }else if(type == VEHICLETYPE.LARGE){
            return LargeVehicleParkingService.getInstance();
        }else
            return null;
    }

}
