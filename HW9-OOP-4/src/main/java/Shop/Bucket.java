package Shop;

import java.util.ArrayList;

public class Bucket {
    ArrayList<Product> products = new ArrayList<Product>();

    public Bucket() {
    }

    public Bucket(ArrayList<Product> products) {
        this.products = products;
    }

    public void Add(Product product) {
        products.add(product);
    }

    public Product RemoveIndex(int index){
        return products.remove(index);
    }
}
