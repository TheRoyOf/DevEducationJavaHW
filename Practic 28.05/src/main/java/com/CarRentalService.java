package com;

import com.enums.ECarClass;
import com.enums.EManufacturer;
import com.enums.EModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalService {
    private static Administrator administrator;
    private static Manager manager;
    private static double driverCost = 100;
    private static List<Bill> billsAwaitingApproval = new ArrayList<>();

    public static void addToAwaitingBills(Bill bill) {
        billsAwaitingApproval.add(bill);
    }

    public static void removeFromAwaitingBills(Bill bill) {
        billsAwaitingApproval.remove(bill);
    }

    public static List<Vehicle> readByManufacturer(EManufacturer manufacturer) {
        return VehicleDatabase.getDatabase().stream().
                filter(vehicle -> vehicle.getManufacturer().equals(manufacturer)).collect(Collectors.toList());
    }

    public static List<Vehicle> readByCarClass(ECarClass carClass) {
        return VehicleDatabase.getDatabase().stream().
                filter(vehicle -> vehicle.getCarClass().equals(carClass)).collect(Collectors.toList());
    }

    public static List<Vehicle> readByModel(EModel model) {
        return VehicleDatabase.getDatabase().stream().
                filter(vehicle -> vehicle.getModel().equals(model)).collect(Collectors.toList());
    }

    public static List<Vehicle> readByPriceRange(double min, double max) {
        return VehicleDatabase.getDatabase().stream().
                filter(vehicle -> vehicle.getPricePerDay() >= min && vehicle.getPricePerDay() <= max)
                .collect(Collectors.toList());
    }

    public static Administrator getAdministrator() {
        return administrator;
    }

    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager manager) {
        CarRentalService.manager = manager;
    }

    public static void setAdministrator(Administrator administrator) {
        CarRentalService.administrator = administrator;
    }

    public static double getDriverCost() {
        return driverCost;
    }
}
