package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void TEST_register() {
        assertTrue(new User().register("ValidUser I.O",
                "AYE00011000EV",
                "validUser",
                "validUserPassword"));
        assertFalse(new User().register("00",
                "0",
                "0",
                "0"));
    }

    @Test
    void TEST_requestVehicle() {
        User user = UserDemo.getValidUser();
        Vehicle vehicle = VehicleDemo.getValidVehicle();
        Bill bill = new Bill(user.toString(),10,150,false,VehicleDemo.getValidVehicle());
        assertEquals(bill, user.requestVehicle(vehicle,10,false));
    }
}