package com.interfaces;

import com.Bill;
import com.Vehicle;

public interface IUser {

    boolean register(String fullName, String passportSerial, String username, String password);

    Bill requestVehicle(Vehicle vehicle, int daysToRent, boolean needsDriver);

    void returnVehicle();
}
