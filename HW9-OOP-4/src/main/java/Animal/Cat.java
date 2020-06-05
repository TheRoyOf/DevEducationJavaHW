package Animal;

public class Cat extends Animal {

    private Vector3 color;

    public Cat(String food, float foodValue, Vector3 location) {
        super(food, foodValue, location);
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Мяу");
    }
}
