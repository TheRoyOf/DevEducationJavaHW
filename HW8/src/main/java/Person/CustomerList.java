package Person;

import java.util.ArrayList;

public class CustomerList {

    static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static ArrayList<Customer> GetByName(String name)
    {
        ArrayList<Customer> rezult = new ArrayList<Customer>();

        for (Customer customer:customers)
        {
            if (customer.name.equals(name))
            {
                rezult.add(customer);
            }
        }

        return rezult;
    }

    public static Customer GetByCardNumber(String card)
    {
        for (Customer customer:customers)
        {
            if (customer.cardNumber.equals(card))
            {
                return customer;
            }
        }
        return null;
    }

}
