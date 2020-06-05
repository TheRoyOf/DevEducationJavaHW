package shop;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private Goods goods = new Goods();
    private String token;

    public Check(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
