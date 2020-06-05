package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void buyGoods() {
        Department department = new Department();
        department.AddGoods(new Goods("Car", 100000));

        Client client = new Client("Car",80000);

        assertEquals(new Goods("Car", 100000), department.BuyGoods(client.getNeeds(),client));
        assertEquals(20000f, client.getCredit());
    }
}