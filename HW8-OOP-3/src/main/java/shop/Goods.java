package shop;

import java.util.Objects;

public class Goods {
    private String name;
    private float price;

    public Goods() {
    }

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Float.compare(goods.price, price) == 0 &&
                Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
