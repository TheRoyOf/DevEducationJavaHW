package Animal;

public class Dog extends Animal {

    private Vector3 size;

    public Dog(String food, float foodValue, Vector3 location) {
        super(food, foodValue, location);
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Гав");
    }
}
