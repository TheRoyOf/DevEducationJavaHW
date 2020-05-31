package com;

import com.interfaces.IUser;

import java.util.Objects;
import java.util.StringJoiner;

public class User implements IUser {
    private static long staticID = 0;
    private long id;
    private String fullName;
    private double money;
    private String passportSerial;
    private String userName;
    private String password;
    private boolean badDrivingRecord;
    private Bill bill;
    private Vehicle rentedVehicle;
    private int daysRented;
    private boolean isBlockedInDatabase;

    public User(String fullName, double money, String passportSerial, String userName, String password, boolean badDrivingRecord) {
        this.id = ++staticID;
        this.money = money;
        this.fullName = fullName;
        this.passportSerial = passportSerial;
        this.userName = userName;
        this.password = password;
        this.badDrivingRecord = badDrivingRecord;
    }

    public User() {
    }

    @Override
    public boolean register(String fullName, String passportSerial, String username, String password) {

        if (fullName.length() < 3) {
            return false;
        }
        if (passportSerial.length() < 6) {
            return false;
        }
        if (username.length() < 4) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        this.fullName = fullName;
        this.passportSerial = passportSerial;
        this.userName = username;
        this.password = password;
        return true;
    }

    @Override
    public Bill requestVehicle(Vehicle vehicle, int daysToRent, boolean needsDriver) {
        double totalCost = vehicle.getPricePerDay() * daysToRent;

        if (needsDriver) {
            totalCost += CarRentalService.getDriverCost() * daysToRent;
        }
        this.bill = new Bill(toString(), daysToRent, totalCost, needsDriver, vehicle);
        CarRentalService.addToAwaitingBills(this.bill);
        return this.bill;
    }

    @Override
    public void returnVehicle() {
        this.setMoney(getMoney() - this.bill.getSumToPay());

        if (this.rentedVehicle.isDamaged()) {
            this.setMoney(getMoney() - this.rentedVehicle.getFeeIfDamaged());
        }
        this.rentedVehicle = null;
        this.bill = null;
    }

    public boolean isBlockedInDatabase() {
        return isBlockedInDatabase;
    }

    public void setBlockedInDatabase(boolean blockedInDatabase) {
        isBlockedInDatabase = blockedInDatabase;
    }

    public double getMoney() {
        return money;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBadDrivingRecord() {
        return badDrivingRecord;
    }

    public Bill getBill() {
        return bill;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public void setRentedVehicle(Vehicle rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.money, money) == 0 &&
                badDrivingRecord == user.badDrivingRecord &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(passportSerial, user.passportSerial) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, fullName, passportSerial, userName, password, badDrivingRecord);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("money=" + money)
                .add("fullName='" + fullName + "'")
                .add("passportSerial='" + passportSerial + "'")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("badDrivingRecord=" + badDrivingRecord)
                .add("bill=" + bill)
                .toString();
    }
}
