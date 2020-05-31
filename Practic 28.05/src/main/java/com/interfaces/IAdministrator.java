package com.interfaces;

import com.Manager;
import com.User;
import com.Vehicle;

public interface IAdministrator {

    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);

    Vehicle editVehicleInfo(long vehicleId,
                            double pricePerDay,
                            double feeIfDamaged,
                            boolean isDamaged,
                            boolean isRented);

    void blockUser(User user);

    void unblockUser(User user);

    void addManager(Manager manager);

    void removeManager(Manager manager);
}
