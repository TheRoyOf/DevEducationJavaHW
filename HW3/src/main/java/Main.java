import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Area.main(null);
        ClassX.main(null);
        System.out.println("Hipotenuse " + Pifagor.CalcHipotenuse(2,3));
        System.out.println("Условные конструкции");
        System.out.println("Metod IF " + InputTester.GetVal(EMetod.If));
        System.out.println("Metod Switch " + InputTester.GetVal(EMetod.Switch));
        System.out.println("Metod Ternar " + InputTester.GetVal(EMetod.Ternar));
    }
}


//Задача 1. Выберите строки, где требуется явное приведение.

/*    int q = 'q';  // 1
    char ch2 = q; // 2
    short s = 1;  // 3
    char ch3 = s; // 4
*/

// ---------> Приведение требуется для строк 2 и 4 <---------

//Задача 2. Вычислить площадь круга (переменная area). Код писать только в указанный рамках (// ... //)

class Area {

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


//Задача 3. Найти и устранить ошибку, не удаляя ничего в коде! Подсказка - необходимо что-то сделать с одной строкой. Код должен компилироваться.

class ClassX {

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

        System.out.println("x is " + x);
    }
}

//Задача 4*. реализовать расчет гипотенузы по теореме Пифагора для целочисленных (int) и дробных (double) значений катетов. Т.е. меняя только сами значения катетов, программа все равно должна компилироваться и верно рассчитывать гипотенузу.

class Pifagor
{
    public static double CalcHipotenuse(double catet_A, double catet_B)
    {
        return Math.sqrt(Math.pow(catet_A,2) + Math.pow(catet_B,2));
    }
    public static double CalcHipotenuse(int catet_A, int catet_B)
    {
        return Math.sqrt(Math.pow(catet_A,2) + Math.pow(catet_B,2));
    }
}

//Задача 5: Необходимо написать программу, где бы пользователю предлагалось ввести число на выбор: 1, 2 или 3, а программа должна сказать, какое число ввёл пользователь: 1, 2, или 3. Если пользователь ввёл другое число, программа должна вывести сообщение: "Вы ввели другое число". Используем Scanner для ввода с консоли и конструкцию if else

//Задача 6: Тоже самое что и Задача 5 только используем switch

//Задача 7: Тоже самое что и Задача 5 только используем тернарный оператор

enum EMetod
{
    If,
    Switch,
    Ternar;
}

class InputTester
{
    /**
     * Метод выполняет получение данных от пользователя и передаёт их в метод проверки.
     * @param metod - Метод проверки введенного пользователем значения
     */
    public static String GetVal(EMetod metod)
    {
        System.out.println("Enter value ");
        Scanner scaner = new Scanner(System.in);
        int val = scaner.nextInt();

        return TestValue(metod,val);
    }

    public static String TestValue(EMetod metod, int val)
    {
        switch (metod)
        {
            case If:

                if(val == 1 || val == 2 || val == 3)
                {
                    return Double.toString(val);
                }
                else
                {
                    return "Invalid value";
                }
            case Switch:

                switch (val)
                {
                    case 1: return Double.toString(val);
                    case 2: return Double.toString(val);
                    case 3: return Double.toString(val);
                    default: return "Invalid value";
                }
            case Ternar:
                return 1 == val || 2 == val || 3 == val ? Double.toString(val) : "Invalid value";
        }
        return "Error";
    }
}