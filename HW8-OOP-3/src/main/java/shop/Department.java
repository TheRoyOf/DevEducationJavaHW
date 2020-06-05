package shop;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Goods> goods = new ArrayList<Goods>();
    private float moneyBox = 0;

    public void AddGoods(Goods goods)
    {
        this.goods.add(goods);
    }

    public Goods BuyGoods(String name, Client client)
    {
        if (ContainsByName(name))
        {
            Goods findGoods = GetByName(name);
            if(client.getMoney()>=findGoods.getPrice())
            {
                client.setMoney(client.getMoney() - findGoods.getPrice());
                client.setCheck(new Check(TokenGenerator.generateToken(findGoods)));
                client.getCheck().setGoods(findGoods);
                client.setGoods(findGoods);
                moneyBox += findGoods.getPrice();
                goods.remove(findGoods);
                return findGoods;
            }
            else
            {
                if(Bank.GetCredit(client, findGoods))
                {
                    return BuyGoods(name,client);
                }
            }
        }
        return null;
    }
    
    private boolean ContainsByName(String name)
    {
        for (Goods good : goods) {
            if (good.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    private Goods GetByName(String name)
    {
        for (Goods good : goods) {
            if (good.getName().equals(name))
            {
                return good;
            }
        }
        return null;
    }
}
