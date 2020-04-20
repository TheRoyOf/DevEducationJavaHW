import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        while(true)
        {
            Value val = ParseValue(EnterValue());
            System.out.println(Calc(val));
        }
    }

    public static String EnterValue()
    {
        System.out.printf("Enter value ");
        return new Scanner(System.in).nextLine();
    }

    public static boolean isNumeric(String str) {
        if (str == null)
        {
            return false;
        }
        try {
            int val = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Value ParseValue(String enterValue)
    {
        enterValue = enterValue.replaceAll(" ","");
        String[] valueArr = enterValue.split("");

        Value value = new Value("");
        boolean first_val = true;

        for(int i = 0; i<valueArr.length; ++i)
        {
            if (first_val)
            {
                if (isNumeric(valueArr[i]))
                {
                    value.val_A = value.val_A + valueArr[i];
                }
                else if (valueArr[i].equals("+") || valueArr[i].equals("-") || valueArr[i].equals("*") || valueArr[i].equals("/"))
                {
                    if (value.action.equals(""))
                    {
                        value.action = valueArr[i];
                        first_val = false;
                    }
                    else
                    {
                        return (new Value("Invalid string"));
                    }
                }
                else
                {
                    return (new Value("Invalid string"));
                }
            }
            else
            {
                if (isNumeric(valueArr[i]))
                {
                    value.val_B = value.val_B + valueArr[i];
                }
                else if (valueArr[i].equals("+") || valueArr[i].equals("-") || valueArr[i].equals("*") || valueArr[i].equals("/"))
                {
                    return (new Value("Invalid string"));
                }
                else
                {
                    return (new Value("Invalid string"));
                }
            }
        }
        return value;
    }

    public static String Calc(Value val)
    {
        double rez = 0;

        if (!val.val_A.equals("Invalid string") && !val.val_A.equals("") && !val.val_B.equals("") && !val.action.equals(""))
        {
            if (val.action.equals("+"))
            {
                rez = Double.parseDouble(val.val_A) + Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("-"))
            {
                rez = Double.parseDouble(val.val_A) - Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("*"))
            {
                rez = Double.parseDouble(val.val_A) * Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("/"))
            {
                rez = Double.parseDouble(val.val_A) / Double.parseDouble(val.val_B);
            }
        }
        else
        {
            System.out.println("Invalid string");
        }
        return Integer.toString((int)rez);
    }
}
