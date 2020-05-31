package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void TEST_manageUserRequest() {
        Bill validBill = new Bill(UserDemo.getValidUser().toString(),10,150,false,VehicleDemo.getValidVehicle());
        Bill firstInvalidBill = new Bill("",10,150,false,VehicleDemo.getValidVehicle());
        Bill secondInvalidBill = new Bill(UserDemo.getValidUser().toString(),10,150,false,VehicleDemo.getInvalidVehicle());

        assertTrue(new Manager("test").manageUserRequest(validBill));
        assertFalse(new Manager("test").manageUserRequest(firstInvalidBill));
        assertFalse(new Manager("test").manageUserRequest(secondInvalidBill));
    }
}