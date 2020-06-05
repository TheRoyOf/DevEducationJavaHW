package com;

import com.enums.EApartmentStatus;
import com.enums.EApartmentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void addBooking() {
    }

    @Test
    void getUnmanagedBooking() {
    }

    @BeforeAll
    void setup()
    {
        Hotel.addApartment(new Apartment(54f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(65f,3,EApartmentType.CLASIC,EApartmentStatus.BOOKING));
        Hotel.addApartment(new Apartment(412f,1,EApartmentType.PREMIUM,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(45f,2,EApartmentType.VIP,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(585f,5,EApartmentType.CLASIC,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(12f,4,EApartmentType.CLASIC,EApartmentStatus.BUSY));
        Hotel.addApartment(new Apartment(54f,6,EApartmentType.VIP,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(12f,3,EApartmentType.CLASIC,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(10f,1,EApartmentType.CLASIC,EApartmentStatus.BLOCK));
        Hotel.addApartment(new Apartment(88f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        Hotel.addApartment(new Apartment(56f,5,EApartmentType.CLASIC,EApartmentStatus.BLOCK));
        Hotel.addApartment(new Apartment(489f,4,EApartmentType.VIP,EApartmentStatus.FREE));
    }

    @Test
    void getByFilter() {

        List<Apartment> expectedByPrice = new ArrayList<>();

        List<Apartment> expectedByType = new ArrayList<>();

        List<Apartment> expectedBySeats = new ArrayList<>();

        List<Apartment> expectedByStatus = new ArrayList<>();

        //price
        expectedByPrice.add(new Apartment(54f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByPrice.add(new Apartment(65f,3,EApartmentType.CLASIC,EApartmentStatus.BOOKING));
        expectedByPrice.add(new Apartment(45f,2,EApartmentType.VIP,EApartmentStatus.FREE));
        expectedByPrice.add(new Apartment(12f,4,EApartmentType.CLASIC,EApartmentStatus.BUSY));
        expectedByPrice.add(new Apartment(54f,6,EApartmentType.VIP,EApartmentStatus.FREE));
        expectedByPrice.add(new Apartment(12f,3,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByPrice.add(new Apartment(10f,1,EApartmentType.CLASIC,EApartmentStatus.BLOCK));
        expectedByPrice.add(new Apartment(88f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByPrice.add(new Apartment(56f,5,EApartmentType.CLASIC,EApartmentStatus.BLOCK));

        //seats
        expectedBySeats.add(new Apartment(54f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedBySeats.add(new Apartment(45f,2,EApartmentType.VIP,EApartmentStatus.FREE));
        expectedBySeats.add(new Apartment(88f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));

        //type
        expectedByType.add(new Apartment(54f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByType.add(new Apartment(65f,3,EApartmentType.CLASIC,EApartmentStatus.BOOKING));
        expectedByType.add(new Apartment(585f,5,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByType.add(new Apartment(12f,4,EApartmentType.CLASIC,EApartmentStatus.BUSY));
        expectedByType.add(new Apartment(12f,3,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByType.add(new Apartment(10f,1,EApartmentType.CLASIC,EApartmentStatus.BLOCK));
        expectedByType.add(new Apartment(88f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByType.add(new Apartment(56f,5,EApartmentType.CLASIC,EApartmentStatus.BLOCK));

        //status
        expectedByStatus.add(new Apartment(54f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(412f,1,EApartmentType.PREMIUM,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(45f,2,EApartmentType.VIP,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(585f,5,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(54f,6,EApartmentType.VIP,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(12f,3,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(88f,2,EApartmentType.CLASIC,EApartmentStatus.FREE));
        expectedByStatus.add(new Apartment(489f,4,EApartmentType.VIP,EApartmentStatus.FREE));

        assertArrayEquals(expectedByPrice.toArray(), Hotel.GetByFilter(100f, Hotel.getApartments()).toArray());

    }

    @Test
    void getToken() {
    }
}