package practice.wednesday_27_05;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class Checkpoint {
    private static final int min = 1;
    private static final int max = 10;
    private int price = ThreadLocalRandom.current().nextInt(min, max + 1);

    public Checkpoint() {
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkpoint that = (Checkpoint) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Checkpoint.class.getSimpleName() + "[", "]")
                .add("price=" + price)
                .toString();
    }
}
