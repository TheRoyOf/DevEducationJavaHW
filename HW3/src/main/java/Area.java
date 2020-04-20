public class Area {

    public static void main(String[] args) {
        calculateAreaOfCircle();
    }

    private static void calculateAreaOfCircle() {
        double pi = 3.1416;
        int radius = 10;

//тут должен быть ваш код
        float area = (float)(Math.PI * Math.pow(radius,2)); // библиотека Math уже содержит константу PI, воспользуемся ей, ну и приведём вывод double к типу float
//
        System.out.printf("Area of circle is %.2f\n", area);
    }
}