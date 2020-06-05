package Animal;

public class HomoSapiens extends Animal {
    public HomoSapiens(String food, float foodValue, Vector3 location) {
        super(food, foodValue, location);
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("А на когда можно собачку записать?");
    }
}
