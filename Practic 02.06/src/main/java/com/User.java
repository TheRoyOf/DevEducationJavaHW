package com;

import com.enums.EApartmentType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    public String fullName;
    public String username;
    private String passwordHash;
    public String authDate;
    public String authToken;

    public void NewBooking(int seats, EApartmentType apartmentType, int daysOfStay) {
        new Booking(this, seats,apartmentType,daysOfStay);
    }

    public boolean Register(String fullName, String username, String passwordHash) {

        if (fullName.length() > 4 && username.length() > 3 && passwordHash.length() > 5)
            return false;

        this.fullName = fullName;
        this.username = username;
        this.passwordHash = passwordHash;

        return true;
    }

    public String Login(String username, String password) throws NoSuchAlgorithmException {

        if (!EncryptStr(password).equals(this.passwordHash))
            return null;

        if (username.equals(this.username)) {
            authDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            authToken = Hotel.GetToken(fullName, username, authDate);
        }
        return authToken;
    }

    private String EncryptStr(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        return new String(messageDigest.digest());
    }

    public void BookingError() {
        System.out.println("Booking error!");
    }
}
