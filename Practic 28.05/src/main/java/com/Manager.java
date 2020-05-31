package com;

import com.interfaces.IManager;

import java.util.Objects;
import java.util.StringJoiner;

public class Manager implements IManager {
    private String name;

    @Override
    public boolean manageUserRequest(Bill bill) {

        if (bill.getUserInfo().length() < 5) {
            return false;
        }
        if (bill.getRentedVehicle().isDamaged() || bill.getRentedVehicle().isRented()) {
            return false;
        }

        CarRentalService.removeFromAwaitingBills(bill);
        return true;
    }

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(name, manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Manager.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
