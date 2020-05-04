import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]arr = {2, 4, 6, 8, 10, 9, 7, 5, 3, 1};

        System.out.println(Arrays.toString(fillRandom(10)));
        System.out.println(Arrays.toString(squareRange(arr,3,7)));

        System.out.println(maxLineValue());

        int[][]arr2x = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(diagonalIsLowThat(arr2x,20));
        System.out.println(tester(arr2x));

    }

    public static int[] fillRandom(int size) {
        int[] arr = new int[size];
        int index = 0;
        boolean flag;

        while (index < arr.length) {
            flag = true;
            arr[index] = (int) (Math.random() * Integer.MAX_VALUE);
            for (int i = 0; i < index; i++) {
                if (i != index && arr[index] == arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ++index;
            }
        }
        return arr;
    }

    public static int[] squareRange(int[] arr, int from, int to) {
        int rezArr[] = new int[to - from];

        for (int i = 0; i < to - from; i++) {
            rezArr[i] = (int) Math.pow(arr[i], 2);
        }
        return rezArr;
    }

    public static int maxLineValue() {
        int[][] arr = new int[7][4];

        int maxSum = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10 - 5);
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                tempSum += arr[i][j];
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static boolean diagonalIsLowThat(int[][] arr, int maxVal) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        if (sum < maxVal) return true;
        return false;
    }

    public static boolean tester(int[][] arr)
    {
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i][i]<arr[i-1][i-1]) {
                System.out.println("Failed id "+i);
                return false;
            }
        }
        return true;
    }
}
