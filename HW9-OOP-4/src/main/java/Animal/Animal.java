package Animal;

public class Animal {
    private String food;
    private float foodValue;
    private Vector3 location;

    public Animal(String food, float foodValue, Vector3 location) {
        this.food = food;
        this.foodValue = foodValue;
        this.location = location;
    }

    public void makeNoise(){}

    public void eat(float findingFood)
    {
        foodValue+=findingFood;
    }

    public void sleep()
    {
        System.out.println("Sleep");
    }

    public String getFood() {
        return food;
    }

    public Vector3 getLocation() {
        return location;
    }

    public String getStringLocation(Vector3 location)
    {
        return location.x+", "+location.y+", "+location.z;
    }
}
