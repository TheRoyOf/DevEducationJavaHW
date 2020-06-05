package Shop;

import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Product> category = new ArrayList<Product>();

    public Category(String name, ArrayList<Product> products) {
        this.name = name;
        this.category = products;
    }

    public Category(){
    }

    public void Add(Product product){
        category.add(product);
    }

    public Product removeIndex(int index){
        return category.remove(index);
    }
}
