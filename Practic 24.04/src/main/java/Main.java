import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Absolute Difference");
        System.out.print("Enter value ");
        System.out.println("Rezult " + AbsoluteDiff(NewScanner().nextInt()));

        System.out.println("Remove Index");
        System.out.print("Enter string, index ");
        System.out.println("Rezult " + RemoveIndex(NewScanner().nextLine(), NewScanner().nextInt()));

        System.out.println("Add last");
        System.out.print("Enter string ");
        System.out.println("Rezult " + AddLast(NewScanner().nextLine()));

        System.out.println("Is 'hi'");
        System.out.print("Enter string ");
        System.out.println("Rezult " + isHi(NewScanner().nextLine()));

        System.out.println("Is contains betven 1-3 'e'");
        System.out.print("Enter string ");
        System.out.println("Rezult " + containsBetween(NewScanner().nextLine()));

        System.out.println("Parse Nth ellement");
        System.out.print("Enter string, n ");
        System.out.println("Rezult " + parseNthEl(NewScanner().nextLine(), NewScanner().nextInt()));

        System.out.println("Change Last-First");
        System.out.print("Enter string ");
        System.out.println("Rezult " + changeLastFirst(NewScanner().nextLine()));

        System.out.println("Temperature");
        System.out.print("Enter celsius ");
        double temperature = NewScanner().nextDouble();
        double temp_F = ConvertCtoF(temperature);
        double temp_K = ConvertCtoK(temperature);
        System.out.print("C to F " + ConvertCtoF(temperature));
        System.out.print(", F to C " + ConvertFtoC(temp_F));
        System.out.print(", C to K " + ConvertCtoK(temperature));
        System.out.print(", K to C " + ConvertKtoC(temp_K));
        System.out.print(", F to K " + ConvertFtoK(temp_F));
        System.out.print(", K to F " + ConvertKtoF(temp_K));
    }

    public static Scanner NewScanner() {
        return new Scanner(System.in);
    }

    public static double AbsoluteDiff(int n) {
        if (n > 21) {
            return (Math.abs(21 - n) * 2);
        }
        return (21 - n);
    }

    public static String RemoveIndex(String string, int index) {
        String temp_string = "";
        for (int i = 0; i < string.length(); i++) {
            if (i == index)
                continue;
            temp_string = temp_string + string.charAt(i);
        }
        return temp_string;
    }

    public static String AddLast(String string) {
        if (string.length() == 0) {
            return string;
        }
        return string.charAt(string.length() - 1) + string + string.charAt(string.length() - 1);
    }

    public static boolean isHi(String string) {
        if (string.charAt(0) == 'h' && string.charAt(1) == 'i') {
            return true;
        }
        return false;
        // в принципе тут можно сделать через substring, вырезать первые 2 символа и сравнить с строкой "hi"
    }

    public static boolean containsBetween(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i, i + 1).equals("e"))
                counter += 1;
        }
        return (counter >= 3);
    }

    public static String parseNthEl(String string, int n) {
        String tempString = "";
        for (int i = 0; i < string.length(); i = i + n) {
            tempString = tempString + string.substring(i, i + 1);
        }
        return tempString;
    }

    public static String changeLastFirst(String string) {
        return string.charAt(string.length() - 1) + string.substring(1, string.length() - 1) + string.charAt(0);
    }

    public static double ConvertCtoF(double temperature) {
        return temperature * 1.8 + 32;
    }

    public static double ConvertFtoC(double temperature) {
        return ((temperature - 32) / 1.8);
    }

    public static double ConvertCtoK(double temperature) {
        return temperature + 273.15;
    }

    public static double ConvertKtoC(double temperature) {
        return temperature - 273.15;
    }

    public static double ConvertFtoK(double temperature) {
        return 273.5 + ((temperature - 32.0) * (5.0 / 9.0));
    }

    public static double ConvertKtoF(double temperature) {
        return ((9.0 / 5.0) * temperature) - 459.67;
    }

}


/*
* 1) Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.

diff21(19) → 2
diff21(10) → 11
diff21(21) → 0

************************************

2) Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).

missingChar("kitten", 1) → "ktten"
missingChar("kitten", 0) → "itten"
missingChar("kitten", 4) → "kittn"

************************************

3) Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.

backAround("cat") → "tcatt"
backAround("Hello") → "oHelloo"
backAround("a") → "aaa"

************************************

4) Given a string, return true if the string starts with "hi" and false otherwise.

startHi("hi there") → true
startHi("hi") → true
startHi("hello hi") → false

************************************

5) Return true if the given string contains between 1 and 3 'e' chars.

stringE("Hello") → true
stringE("Heelle") → true
stringE("Heelele") → false

************************************

6) Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string.
So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.

everyNth("Miracle", 2) → "Mrce"
everyNth("abcdefg", 2) → "aceg"
everyNth("abcdefg", 3) → "adg"

************************************

7) Given a string, return a new string where the first and last chars have been exchanged. (Without stringBuffer - reverse)

frontBack("code") → "eodc"
frontBack("a") → "a"
frontBack("ab") → "ba"

************************************

8) Java program to convert Fahrenheit <--> Celsius, Celsius  <-->  Kelvin, Kelvin <--> Fahrenheit

************************************
* */