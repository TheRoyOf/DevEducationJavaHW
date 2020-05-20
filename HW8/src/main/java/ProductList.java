import java.util.ArrayList;

public class ProductList {

    static ArrayList<Product> products = new ArrayList<Product>();

    public static ArrayList<Product> GetByName(String name)
    {
        ArrayList<Product> rez = new ArrayList<Product>();

        for (Product product:products)
        {
            if (product.name.equals(name))
                rez.add(product);
        }
        return rez;
    }

    public static ArrayList<Product> GetByNameMaxPrice(String name, int price)
    {
        ArrayList<Product> rez = new ArrayList<Product>();

        for (Product product:products)
        {
            if (product.name.equals(name) && product.price<=price)
                rez.add(product);
        }
        return rez;
    }

    public static ArrayList<Product> GetByLifeTime(int lifetime)
    {
        ArrayList<Product> rez = new ArrayList<Product>();

        for (Product product:products)
        {
            if (product.lifetime >= lifetime)
                rez.add(product);
        }
        return rez;
    }
}
