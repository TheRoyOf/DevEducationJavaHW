import java.util.Scanner;

public class InputTester
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
