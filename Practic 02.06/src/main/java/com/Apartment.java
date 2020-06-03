package com;

import com.enums.EApartmentStatus;
import com.enums.EApartmentType;

import java.util.Objects;

public class Apartment {
    public float price;
    public int seats;
    public EApartmentType apartmentType;
    public EApartmentStatus apartmentStatus;

    public Apartment(float price, int seats, EApartmentType apartmentType, EApartmentStatus apartmentStatus) {
        this.price = price;
        this.seats = seats;
        this.apartmentType = apartmentType;
        this.apartmentStatus = apartmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Float.compare(apartment.price, price) == 0 &&
                seats == apartment.seats &&
                apartmentType == apartment.apartmentType &&
                apartmentStatus == apartment.apartmentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, seats, apartmentType, apartmentStatus);
    }
}
