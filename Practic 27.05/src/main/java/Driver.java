package practice.wednesday_27_05;

import java.util.*;

public class Driver {
    private int debt = 0;
    private List<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    public Driver() {
    }

    public void payTheToll(int price) {
        int debt = this.debt;

        if (coins.contains(price)) {
            coins.remove(coins.indexOf(price));
        } else {
            if (findClosestCoin(price) < price) {
                debt += price - findClosestCoin(price);
            }
            coins.remove(coins.indexOf(findClosestCoin(price)));
        }
        this.debt = debt;
    }

    public int findClosestCoin(int price) {
        int lastClosest = Integer.MAX_VALUE;
        int lastItem = 0;

        for (Integer coin : coins) {
            if (Math.abs(coin - price) <= lastClosest) {
                lastClosest = Math.abs(coin - price);
                lastItem = coin;
            }
        }
        return lastItem;
    }

    public int getDebt() {
        return debt;
    }

    public List<Integer> getCoins() {
        return coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return debt == driver.debt &&
                Objects.equals(coins, driver.coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debt, coins);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Driver.class.getSimpleName() + "[", "]")
                .add("debt=" + debt)
                .add("coins=" + coins)
                .toString();
    }
}
