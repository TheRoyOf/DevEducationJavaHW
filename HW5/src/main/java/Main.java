import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 234, 23, 5, 432, 85, 72, 54, 12, 9, 45, 61, 384, 4, 989435, 34, 8, 46, 47, 6, 6};
        System.out.println(Arrays.toString(bubleSort(arr)));
        System.out.println("Max " + Max(arr));
        System.out.println("Max3 " + Arrays.toString(Max3(arr)));
        System.out.println("Reverse " + Arrays.toString(reverse(arr)));
        System.out.println("Reiteration " + Arrays.toString(reiteration(arr)));
        System.out.println("Mirror array " + Arrays.toString(fillMirrorArray(25)));
        System.out.println("Task 7");
        Task7();
    }

    public static int[] bubleSort(int[] arr) {
        int temp;
        int counter;
        do {
            counter = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    ++counter;
                }
            }
        } while (counter != 0);
        return arr;
    }

    public static int Max(int[] arr) {
        int max = 0;
        for (int value : arr) {
            if (value > max)
                max = value;
        }
        return max;
    }

    public static int[] Max3(int[] arr) {
        int[] max3 = new int[3];

        bubleSort(arr);

        for (int value : arr) {
            if (value != max3[0] && value != max3[1] && value != max3[2] && value > max3[0]) {
                max3[2] = max3[1];
                max3[1] = max3[0];
                max3[0] = value;
            }
        }
        return max3;
    }

    public static int[] reverse(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[arr.length - 1 - i] = arr[i];
        }
        return tempArr;
    }

    public static int[] reiteration(int[] arr) {
        int countedItem;
        int counter;
        int MaxItem = 0;
        int countMaxItem = 0;

        for (int i = 0; i < arr.length; i++) {
            countedItem = i;
            counter = 0;
            for (int value : arr) {
                if (value == countedItem) {
                    ++counter;
                }
            }
            if (countMaxItem < counter) {
                MaxItem = countedItem;
                countMaxItem = counter;
            }
        }
        return new int[]{MaxItem, countMaxItem};
    }

    public static int[] fillMirrorArray(int size) {
        int center = size / 2;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.abs(center - i);
        }
        return arr;
    }

    public static void Task7() {
        Scanner scaner = new Scanner(System.in);

        int lenght;
        int center;

        int sumLeft =0;
        int sumRight=0;

        do {
            lenght = scaner.nextInt();
        } while (!(lenght > 0 && lenght % 2 == 0));

        center = lenght/2;

        int[] arr = new int[lenght];

        for (int i = 0; i < lenght; i++) {
            arr[i] = new Random().nextInt(5);
        }

        for (int i = 0;i<center;i++)
        {
            sumLeft += Math.abs(arr[i]);
        }

        for (int i = center+1;i<lenght;i++)
        {
            sumRight += Math.abs(arr[i]);
        }

        System.out.println("Array " + Arrays.toString(arr));

        if (sumLeft>sumRight)
        {
            System.out.println("Левая часть больше");
        }
        else if(sumRight > sumLeft)
        {
            System.out.println("Правая часть больше");
        }
        else
        {
            System.out.println("Части равны");
        }

    }
}
