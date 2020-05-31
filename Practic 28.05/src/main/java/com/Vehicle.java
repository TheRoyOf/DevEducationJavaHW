package com;

import com.enums.ECarClass;
import com.enums.EManufacturer;
import com.enums.EModel;

import java.util.Objects;
import java.util.StringJoiner;

public class Vehicle {
    private static long staticID = 0;
    private long id;
    private double pricePerDay;
    private double feeIfDamaged;
    private boolean isDamaged;
    private boolean isRented;
    private EModel model;
    private EManufacturer manufacturer;
    private ECarClass carClass;

    public Vehicle(double pricePerDay,
                   double feeIfDamaged,
                   boolean isRented,
                   EModel model,
                   EManufacturer manufacturer,
                   ECarClass carClass) {
        this.id = ++staticID;
        this.pricePerDay = pricePerDay;
        this.feeIfDamaged = feeIfDamaged;
        this.isRented = isRented;
        this.model = model;
        this.manufacturer = manufacturer;
        this.carClass = carClass;
    }

    public long getId() {
        return id;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public double getFeeIfDamaged() {
        return feeIfDamaged;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public boolean isRented() {
        return isRented;
    }

    public EModel getModel() {
        return model;
    }

    public EManufacturer getManufacturer() {
        return manufacturer;
    }

    public ECarClass getCarClass() {
        return carClass;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setFeeIfDamaged(double feeIfDamaged) {
        this.feeIfDamaged = feeIfDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setModel(EModel model) {
        this.model = model;
    }

    public void setManufacturer(EManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCarClass(ECarClass carClass) {
        this.carClass = carClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.pricePerDay, pricePerDay) == 0 &&
                Double.compare(vehicle.feeIfDamaged, feeIfDamaged) == 0 &&
                isDamaged == vehicle.isDamaged &&
                model == vehicle.model &&
                manufacturer == vehicle.manufacturer &&
                carClass == vehicle.carClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerDay, feeIfDamaged, isDamaged, model, manufacturer, carClass);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicle.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("pricePerDay=" + pricePerDay)
                .add("feeIfDamaged=" + feeIfDamaged)
                .add("isDamaged=" + isDamaged)
                .add("isRented=" + isRented)
                .add("model=" + model)
                .add("manufacturer=" + manufacturer)
                .add("carClass=" + carClass)
                .toString();
    }
}
