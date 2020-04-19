import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        
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

            if (val != "s" && isInteger)
            {
                enterArgs.add(Integer.parseInt(val));
            }
            else if (val == "s" && enterArgs.size()<2)
            {
                System.out.println("Enter 2 or more values.");
            }
            else if (val == "s")
            {
                active = false;
            }
            else
            {
                System.out.println("Enter valid values.");
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

    public static String PrintANCIISymbol()
    {
        String string = "ANCII";
        for(int i = 0;i<=255;++i)
        {
            string = string + " '" + (char)i + "'";
        }
        return  string;
    }
}

