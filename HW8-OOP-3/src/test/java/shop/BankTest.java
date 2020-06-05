package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void getCredit() {
        Client client = new Client("Car", 1000f);
        assertTrue(Bank.GetCredit(client,new Goods("Car", 100000)));
        assertFalse(Bank.GetCredit(client,new Goods("Car", 1)));
    }
}