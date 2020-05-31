package com;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class VehicleDatabase {

    private static List<Vehicle> database = new ArrayList<>();


    protected static List<Vehicle> getDatabase() {
        return database;
    }

    protected static void addVehicle(Vehicle vehicle) {
        database.add(vehicle);
    }

    protected static void removeVehicle(Vehicle vehicle) {
        database.remove(vehicle);
    }

    protected static Vehicle editVehicle(long vehicleId,
                                         double pricePerDay,
                                         double feeIfDamaged,
                                         boolean isDamaged,
                                         boolean isRented) {
        for (Vehicle vehicle : database) {
            if (vehicle.getId() == vehicleId) {
                vehicle.setPricePerDay(pricePerDay);
                vehicle.setFeeIfDamaged(feeIfDamaged);
                vehicle.setDamaged(isDamaged);
                vehicle.setRented(isRented);
                return vehicle;
            } else {
                throw new NoSuchElementException("There's no vehicle with matching id in database");
            }
        }
        return null;
    }
}
