package com;

import com.enums.EApartmentType;
import com.interfaces.IUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements IUser {
    public String fullName;
    public String username;
    private String passwordHash;
    public String authDate;
    public String authToken;

    @Override
    public void NewBooking(int seats, EApartmentType apartmentType, int daysOfStay) {
        new Booking(this, seats,apartmentType,daysOfStay);
    }

    @Override
    public boolean Register(String fullName, String username, String passwordHash) {

        if (fullName.length() > 4 && username.length() > 3 && passwordHash.length() > 5)
            return false;

        this.fullName = fullName;
        this.username = username;
        this.passwordHash = passwordHash;

        return true;
    }

    @Override
    public String Login(String username, String password) throws NoSuchAlgorithmException {

        if (!EncryptStr(password).equals(this.passwordHash))
            return null;

        if (username.equals(this.username)) {
            authDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            authToken = Hotel.GetToken(fullName, username, authDate);
        }
        return authToken;
    }

    @Override
    public boolean ApplyBooking(Booking booking)
    {
        if (booking.getApartment() != null && booking.moderate)
            return true;
        return false;
    }

    private String EncryptStr(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        return new String(messageDigest.digest());
    }

    @Override
    public void BookingError() {
        System.out.println("Booking error!");
    }
}
