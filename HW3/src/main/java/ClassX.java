public class ClassX {

    public static void main(String[] args) {
        computeX();
    }

    private static void computeX() {
        int x;
        x = 10;
        if (x == 10) {
            int y = 20;
            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        }
        int y = 100; // <---------- Область видимости переменной У ограничена условным оператором выше, потому нам необходимо объявить переменную заново
    // Как вариант, можно было бы просто закомментировать или переместить на строчку выше в область видимости 
        System.out.println("x is " + x);
    }
}
