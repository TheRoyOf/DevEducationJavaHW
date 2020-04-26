import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter bunny count ");
        System.out.println("Sum bunny ears: " + SumBunnyEars(1, NewScanner().nextInt()));
        System.out.println();
        System.out.print("Enter number ");
        System.out.println("Sum number elements: " + SumNumberElements(NewScanner().nextInt()));
        System.out.println("Is pair bracets: " + isPairBracets("(75(b)8)8"));
        System.out.println("Remove bracets: " + RemoveBracets("(a(b)c)"));
        System.out.println("Get prime numbers: " + GetPrimeNumbers(1000));
        TecTacToe.init();
    }

    public static Scanner NewScanner() {
        return new Scanner(System.in);
    }

    public static int SumNumberElements(int number) {
        return number > 0 ? SumNumberElements(number / 10) + number % 10 : 0;
    }

    public static int SumBunnyEars(int numberBunny, int maxBunny) {
        if (numberBunny <= maxBunny) {
            return numberBunny % 2 == 0 ? SumBunnyEars(numberBunny + 1, maxBunny) + 2 : SumBunnyEars(numberBunny + 1, maxBunny) + 3;
        } else {
            return 0;
        }
    }

    public static boolean isPairBracets(String string) {
        int firstIndex = string.indexOf("(");
        int lastIndex = string.lastIndexOf(")");
        if ((firstIndex == -1 && lastIndex >= 0) || (lastIndex == -1 && firstIndex >= 0)) {
            return false;
        } else if (firstIndex == -1 && lastIndex == -1) {
            return true;
        } else {
            return isPairBracets(string.substring(firstIndex + 1, lastIndex));
        }
    }

    public static String RemoveBracets(String string) {

        String newString = "";

        if (string.length() != 0) {
            if (string.charAt(0) == '(' || string.charAt(0) == ')') {
                newString = newString + "";
            } else {
                newString = newString + string.charAt(0);
            }
            newString = newString + RemoveBracets(string.substring(1));
        }
        return newString;
    }

    public static ArrayList<Integer> GetPrimeNumbers(int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (i < max) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                list.add(i);
            } else if (i == 2 || i == 3 || i == 5) {
                list.add(i);
            }
            ++i;
        }
        return list;
    }
}
