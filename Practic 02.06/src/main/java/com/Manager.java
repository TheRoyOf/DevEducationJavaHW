package com;

import com.enums.EApartmentStatus;
import com.interfaces.IManager;

public class Manager implements IManager {

    @Override
    public Booking CheckBooking(Booking booking)
    {
        booking.setApartment(Hotel.GetByFilter(booking.price,
                    Hotel.GetByFilter(booking.seats,
                        Hotel.GetByFilter(EApartmentStatus.FREE,
                                Hotel.GetByFilter(booking.apartmentType,
                                        Hotel.getApartments())))).get(0));
        booking.moderate = true;
        return booking;
    }
}
