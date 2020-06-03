package com.interfaces;

import com.Booking;
import com.enums.EApartmentType;

import java.security.NoSuchAlgorithmException;

public interface IUser {
    void NewBooking(int seats, EApartmentType apartmentType, int daysOfStay);

    boolean Register(String fullName, String username, String passwordHash);

    String Login(String username, String password) throws NoSuchAlgorithmException;

    boolean ApplyBooking(Booking booking);

    void BookingError();
}
