import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Определить какое из трех, введенных пользователем, чисел максимальное и вывести его на экран.

        System.out.println("Enter 3 values");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i<3; ++i)
        {
            System.out.println("Value " + (i+1) + " = ");
            arr.add(Integer.parseInt(EnterValue()));
        }
        System.out.println("Max value " + MaxValue(arr));

        //Определить количество дней в году, который вводит пользователь. В високосном - 366 дней, в обычном 365.

        System.out.println("Enter ear");
        System.out.println("Days in ear " + DaysInEar(Integer.parseInt(EnterValue())));

        //Вывод на экран алфавит ASCII. Вывод на экран соответствий между символами и их численными обозначениями.

        System.out.println(ANCIISymbol());

        /*
        Пользователь вводит от 2 чисел и больше (проверочка)
        - вывести минимальное на экран.
        - вывести максимальное на экран.
        - вывести сумму всех чисел на экран.
        - вывести среднее значение чисел на экран.
         */
        ArrayList<Integer> testedArr = new ArrayList<Integer>();
        testedArr = EnterListValue();
        System.out.println("Max " + MaxValue(testedArr));
        System.out.println("Min " + MinValue(testedArr));
        System.out.println("Sum " + SumValue(testedArr));
        System.out.println("Average " + AverageValue(testedArr));

        //Вводится натуральное число. Найти сумму четных цифр, входящих в его состав. тест: при вводе числа "1474" на выходе получим "8", так как четными являются лишь две цифры "4".

        System.out.println("Задание 5 и 5.1");
        String str = EnterValue();
        System.out.println("Сумма чётных значений " + SplitString(str).even_sum);
        System.out.println("Количество чётных " + SplitString(str).even);
        System.out.println("Количество чётных " + SplitString(str).uneven);

    }

    public static ArrayList<Integer> EnterListValue()
    {
        System.out.println("Enter 2 or more values. Enter s to stop enter value");
        boolean active = true;
        ArrayList<Integer> enterArgs = new ArrayList<Integer>();
        while (active)
        {
            String val = EnterValue();
            boolean isInteger;

            try {
                Integer.parseInt(val);
                isInteger = true;
            } catch (Exception e) {
                isInteger = false;
            }

            if (!val.equals("s") && isInteger)
            {
                enterArgs.add(Integer.parseInt(val));
            }
            else if (val.equals("s") && enterArgs.size()<2)
            {
                System.out.println("Enter 2 or more values.");
            }
            else if (val.equals("s"))
            {
                active = false;
            }
            else
            {
                System.out.println("Enter valid values. " + val);
            }
        }
        return enterArgs;
    }

    public static String EnterValue()
    {
        System.out.printf("Enter value ");
        return new Scanner(System.in).nextLine();
    }

    public static int MaxValue(ArrayList<Integer> arr)
    {
        int l_MaxVal = 0;
        for (int val : arr)
        {
            if(val>l_MaxVal)
            {
                l_MaxVal = val;
            }
        }
        return l_MaxVal;
    }

    public static int MinValue(ArrayList<Integer> arr)
    {
        int l_MinVal = arr.get(1);
        for (int val : arr)
        {
            if(val<l_MinVal)
            {
                l_MinVal = val;
            }
        }
        return l_MinVal;
    }

    public static int SumValue(ArrayList<Integer> arr)
    {
        int l_Sum = 0;
        for (int val : arr)
        {
            l_Sum += val;
        }
        return l_Sum;
    }

    public static int AverageValue(ArrayList<Integer> arr)
    {
        int l_Sum = 0;
        int l_count = 0;
        for (int val : arr)
        {
            l_Sum += val;
            ++l_count;
        }
        return l_Sum/l_count;
    }

    public static int DaysInEar(int ear)
    {
        /**
         * Воспользуемся вики:
         * год, номер которого кратен 400, — високосный;
         * остальные годы, номер которых кратен 100, — невисокосные (например, го­ды 1700, 1800, 1900, 2100);
         * остальные годы, номер которых кратен 4, — високосные;
         */

        if (ear % 400 == 0)
        {
            return 366;
        }
        else if(ear % 4 == 0 && ear % 100 != 0)
        {
            return 366;
        }
        else
        {
            return 365;
        }
    }

    public static String ANCIISymbol()
    {
        String string = "ANCII: ";
        for(int i = 0;i<=255;++i)
        {
            string = string + i + "-> '" + (char)i + "', ";
        }
        return  string;
    }



    public static Value SplitString(String str)
    {
        Value value = new Value();
        for (String val : str.split(""))
        {
            if(Integer.parseInt(val) % 2 == 0)
            {
                value.even_sum += Integer.parseInt(val);
                ++value.even;
            }
            else
            {
                ++value.uneven;
            }
        }
        return value;
    }
}
