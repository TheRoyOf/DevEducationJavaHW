package com;

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

    public static Booking GetUnmanagedBooking()
    {
        for (Booking booking:bookings)
        {
            if (!booking.moderate)
                return booking;
        }
        return null;
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
