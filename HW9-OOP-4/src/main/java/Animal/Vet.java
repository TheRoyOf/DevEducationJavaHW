package Animal;

public class Vet {

    public static void treatAnimal(Animal animal)
    {
        System.out.println(animal.getStringLocation(animal.getLocation()) + ", " + animal.getFood());
    }
}
