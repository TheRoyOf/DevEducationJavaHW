package Shop;

import Animal.*;

import java.util.ArrayList;
import java.util.List;

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

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog("meat",0.9f,new Vector3(1,2,1)));
        animals.add(new Cat("meat, fish",0.8f,new Vector3(32,7,12)));
        animals.add(new HomoSapiens("any",10f,new Vector3(1232,123,1121)));

        for (Animal animal : animals) {
            Vet.treatAnimal(animal);
        }
    }
}
