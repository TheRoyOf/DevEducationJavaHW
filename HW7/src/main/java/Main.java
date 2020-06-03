import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String string = "Kraken utrhv grutt dot";
        System.out.println("Task 1");
        printTask1(string);
        System.out.println("Task 2");
        printTask2(string);
        System.out.println("Task 3");
        System.out.println(removeBefore(string, 9, 3));
        System.out.println("Task 4");
        printTask4(string);
        System.out.println("Task 5");
        System.out.println("X");
        System.out.println("Task 6");
        System.out.println(isUniqueSimbols(string));
        System.out.println("Max length " + maxLength(isUniqueSimbols(string)));
        System.out.println("Min length " + minLength(isUniqueSimbols(string)));
        System.out.println("Task 7");
        printTask7();
        System.out.println("Task 8");
        System.out.println(isPalindrome("tsest"));
    }

    public static int amountOfRepeats(String str, String symbol) {
        int counter = 0;
        for (char item : str.toCharArray()) {
            if (item == symbol.charAt(0)) {
                counter++;
            }
        }
        return counter;
    }

    public static List<String> getStringItem(String string) {
        List<String> arr = new ArrayList<String>();
        for (String item : string.split("")) {
            if (!arr.contains(item)) {
                arr.add(item);
            }
        }
        return arr;
    }

    public static void printTask1(String string) {
        string = string.toLowerCase();
        for (String item : getStringItem(string)) {
            System.out.println("'" + item + "': " + amountOfRepeats(string, item));
        }
    }

    public static String invert(String string) {
        String temp = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            temp += string.charAt(i);
        }
        return temp;
    }

    public static void printTask2(String string) {
        String temp = "";
        for (String item : string.split(" ")) {
            temp += invert(item) + " ";
        }
        System.out.println(temp);
    }

    public static String removeBefore(String string, int startIndex, int lenght) {
        String temp = "";
        for (int i = 0; i < string.length(); i++) {
            if (i >= startIndex && i < startIndex + lenght)
                continue;
            temp += string.charAt(i);
        }
        return temp;
    }

    public static void printTask4(String string) {
        String temp = "";
        for (String item : string.split(" ")) {
            temp = invert(item) + " " + temp;
        }
        System.out.println(temp);
    }

    public static ArrayList<String> isUniqueSimbols(String string) {
        ArrayList<String> arr = new ArrayList<String>();
        for (String str : string.split(" ")) {
            boolean flag = true;
            for (int c = 0; c < str.length(); c++) {
                for (int i = 0; i < c; i++) {
                    if (str.charAt(i) == str.charAt(c)) {
                        flag = false;
                        break;
                    }
                }

            }
            if (flag) {
                arr.add(str);
            }
        }
        return arr;
    }

    public static String maxLength(ArrayList<String> arr) {
        String prevString = "";
        for (String item : arr) {
            if (item.length() > prevString.length()) {
                prevString = item;
            }
        }
        return prevString;
    }

    public static String minLength(ArrayList<String> arr) {
        String prevString = arr.get(0);
        for (String item : arr) {
            if (item.length() < prevString.length()) {
                prevString = item;
            }
        }
        return prevString;
    }

    public static void printTask7() {
        Scanner scanner = new Scanner(System.in);
        String val = "";
        ArrayList<String> list = new ArrayList<String>();
        do {
            val = scanner.nextLine();
            if (!val.equals("EXIT"))
                list.add(val);
        } while (!val.equals("EXIT"));

        val = "";
        int randomIndex;
        while (list.size()>0)
        {
            randomIndex = (int) (Math.random()*list.size());
            val+=list.get(randomIndex)+" ";
            list.remove(randomIndex);
        }
        System.out.println(val);
    }

    public static boolean isPalindrome(String string)
    {
        boolean flag = true;
        for (int i = 0; i<string.length();i++)
            if (!(string.charAt(i) == string.charAt(string.length()-1-i)))
                flag = false;
        return flag;
    }
}
