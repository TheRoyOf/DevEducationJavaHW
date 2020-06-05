package shop;

public class Bank {
    public static boolean GetCredit(Client client, Goods goods)
    {
        if(client.getCredit() == 0)
        {
            client.setCredit(goods.getPrice() - client.getMoney());
            client.setMoney(client.getMoney() + client.getCredit());
            return true;
        }
        return false;
    }
}
