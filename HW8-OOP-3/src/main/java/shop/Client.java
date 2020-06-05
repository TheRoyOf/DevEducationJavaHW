package shop;

public class Client {
    private String needs;
    private float money;
    private float credit;
    private Check check;
    private Goods goods;

    public Client(String needs, float money) {
        this.needs = needs;
        this.money = money;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getNeeds() {
        return needs;
    }

    public float getMoney() {
        return money;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public Check getCheck() {
        return check;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}
