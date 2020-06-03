package com;

import com.enums.EApartmentType;

public class Booking {
    public User user;

    boolean moderate;
    public int seats;
    public EApartmentType apartmentType;
    public int daysOfStay;
    public float price;

    private Apartment apartment;

    public Booking(User user, int seats, EApartmentType apartmentType, int daysOfStay) {
        this.moderate = false;
        this.user = user;
        this.seats = seats;
        this.apartmentType = apartmentType;
        this.daysOfStay = daysOfStay;

        if(!Hotel.AddBooking(this))
            user.BookingError();
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
