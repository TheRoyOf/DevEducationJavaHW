package com;

import java.util.Objects;
import java.util.StringJoiner;

public class Bill {
    private String userInfo;
    private int daysRented;
    private double sumToPay;
    private boolean needsDriver;
    private Vehicle rentedVehicle;
    private boolean isRequested = false;

    public Bill(String userInfo, int daysRented, double sumToPay, boolean needsDriver, Vehicle rentedVehicle) {
        this.userInfo = userInfo;
        this.daysRented = daysRented;
        this.sumToPay = sumToPay;
        this.needsDriver = needsDriver;
        this.rentedVehicle = rentedVehicle;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getSumToPay() {
        return sumToPay;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bill.class.getSimpleName() + "[", "]")
                .add("userInfo='" + userInfo + "'")
                .add("daysRented=" + daysRented)
                .add("sumToPay=" + sumToPay)
                .add("needsDriver=" + needsDriver)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return daysRented == bill.daysRented &&
                Double.compare(bill.sumToPay, sumToPay) == 0 &&
                needsDriver == bill.needsDriver &&
                isRequested == bill.isRequested &&
                Objects.equals(userInfo, bill.userInfo) &&
                Objects.equals(rentedVehicle, bill.rentedVehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInfo, daysRented, sumToPay, needsDriver, rentedVehicle, isRequested);
    }
}
