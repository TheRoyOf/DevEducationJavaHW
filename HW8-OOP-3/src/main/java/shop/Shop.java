package shop;

public class Shop {
    public static void main(String[]args)
    {
        Department department = new Department();
        department.AddGoods(new Goods("Car", 100000));

        Client client = new Client("Car",120000);

        System.out.println(department.BuyGoods(client.getNeeds(),client));
    }
}
