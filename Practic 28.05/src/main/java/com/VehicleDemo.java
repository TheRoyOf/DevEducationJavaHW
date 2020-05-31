package com;

import com.enums.ECarClass;
import com.enums.EManufacturer;
import com.enums.EModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleDemo {

    public void addVehicles() {
        Vehicle v1 = new Vehicle(15,
                200,
                false,
                EModel.A100,
                EManufacturer.MERCEDES,
                ECarClass.ECONOMY);

        Vehicle v2 = new Vehicle(18,
                300,
                false,
                EModel.C200,
                EManufacturer.MERCEDES,
                ECarClass.STANDARD);

        Vehicle v3 = new Vehicle(30,
                800,
                false,
                EModel.S63_AMG,
                EManufacturer.MERCEDES,
                ECarClass.LUXURY);

        Vehicle v4 = new Vehicle(15,
                200,
                false,
                EModel.COROLLA,
                EManufacturer.TOYOTA,
                ECarClass.ECONOMY);

        Vehicle v5 = new Vehicle(17,
                400,
                false,
                EModel.CAMRY,
                EManufacturer.TOYOTA,
                ECarClass.STANDARD);

        Vehicle v6 = new Vehicle(22,
                700,
                false,
                EModel.LAND_CRUISER_200,
                EManufacturer.TOYOTA,
                ECarClass.LUXURY);

        Vehicle v7 = new Vehicle(16,
                250,
                false,
                EModel.FOCUS,
                EManufacturer.FORD,
                ECarClass.ECONOMY);

        Vehicle v8 = new Vehicle(20,
                500,
                false,
                EModel.F250,
                EManufacturer.FORD,
                ECarClass.STANDARD);

        Vehicle v9 = new Vehicle(100,
                5000,
                false,
                EModel.GT,
                EManufacturer.FORD,
                ECarClass.LUXURY);

        List<Vehicle> database = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9));

        for (Vehicle vehicle : database) {
            VehicleDatabase.addVehicle(vehicle);
        }
    }

    public static Vehicle getValidVehicle()
    {
        return new Vehicle(15,
                200,
                false,
                EModel.A100,
                EManufacturer.MERCEDES,
                ECarClass.ECONOMY);
    }

    public static Vehicle getInvalidVehicle()
    {
        return new Vehicle(15,
                200,
                true,
                EModel.A100,
                EManufacturer.MERCEDES,
                ECarClass.ECONOMY);
    }


}
