import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Category fruits = new Category();
        fruits.Add(new Product("apple", 10.50, 8));
        fruits.Add( new Product("avocado", 20.75, 6));
        fruits.Add(new Product("watermelon", 15.10, 9));
        Category vegetables = new Category();
        vegetables.Add(new Product("tomato", 10.90, 5));
        vegetables.Add(new Product("avocado", 20.75, 6));
        vegetables.Add(new Product("watermelon", 15.10, 9));

        User user = new User("login","password",new Bucket());
        user.Add(new Product("apple", 10.50, 8));
    }
}
