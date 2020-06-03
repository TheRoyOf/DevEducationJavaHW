package com;

import com.enums.EApartmentStatus;
import com.enums.EApartmentType;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static List<Apartment> apartments = new ArrayList<>();
    private static List<Manager> managers = new ArrayList<>();

    private static List<Booking> bookings = new ArrayList<>();

    public static boolean AddBooking(Booking booking)
    {
        if (booking.daysOfStay<1 || !booking.user.authToken.equals(GetToken(booking.user.fullName, booking.user.username, booking.user.authDate)))
            return false;

        bookings.add(booking);
        return true;
    }
    public static boolean addApartment(Apartment apartment)
    {
        return apartments.add(apartment);
    }

    public static List<Apartment> getApartments() {
        return apartments;
    }

    public static Booking GetUnmanagedBooking()
    {
        for (Booking booking:bookings)
        {
            if (!booking.moderate)
                return booking;
        }
        return null;
    }

    public static List<Apartment> GetByFilter(float price, List<Apartment> apartments)
    {
        List<Apartment> rez = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.price<=price)
                rez.add(apartment);
        }
        return rez;
    }

    public static List<Apartment> GetByFilter(int seats, List<Apartment> apartments)
    {
        List<Apartment> rez = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.seats==seats)
                rez.add(apartment);
        }
        return rez;
    }

    public static List<Apartment> GetByFilter(EApartmentStatus apartmentStatus, List<Apartment> apartments)
    {
        List<Apartment> rez = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.apartmentStatus.equals(apartmentStatus))
                rez.add(apartment);
        }
        return rez;
    }

    public static List<Apartment> GetByFilter(EApartmentType apartmentType, List<Apartment> apartments)
    {
        List<Apartment> rez = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.apartmentType.equals(apartmentType))
                rez.add(apartment);
        }
        return rez;
    }

    public static String GetToken(String fullName, String username, String date) {
        StringBuilder token = new StringBuilder();

        int baseHash = 21;
        for(char ch: username.toCharArray())
        {
            token.insert(0, (char) (ch + baseHash));
        }
        for(char ch: fullName.toCharArray())
        {
            token.append((char) (ch + baseHash));
        }
        for(char ch: date.toCharArray())
        {
            token.insert(0, (char) (ch + baseHash));
        }
        return token.toString();
    }
}
