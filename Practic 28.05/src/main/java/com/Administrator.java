package com;

import com.interfaces.IAdministrator;

import java.util.Objects;
import java.util.StringJoiner;

public class Administrator implements IAdministrator {
    private String name;

    @Override
    public void addVehicle(Vehicle vehicle) {
        VehicleDatabase.addVehicle(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        VehicleDatabase.removeVehicle(vehicle);
    }

    @Override
    public Vehicle editVehicleInfo(long vehicleId,
                                   double pricePerDay,
                                   double feeIfDamaged,
                                   boolean isDamaged,
                                   boolean isRented) {
        return VehicleDatabase.editVehicle(vehicleId, pricePerDay, feeIfDamaged, isDamaged, isRented);
    }

    @Override
    public void blockUser(User user) {
        user.setBlockedInDatabase(true);
    }

    @Override
    public void unblockUser(User user) {
        user.setBlockedInDatabase(false);
    }

    @Override
    public void addManager(Manager manager) {
        CarRentalService.setManager(manager);
    }

    @Override
    public void removeManager(Manager manager) {
        CarRentalService.setManager(null);
    }

    public Administrator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Administrator.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
