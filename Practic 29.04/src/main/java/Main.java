import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 22, 24, 25}};
        printCustom(arr5x5);
        System.out.println();
        printArr(fillGrid(7));
        System.out.println();
        System.out.println(countElements(arr5x5));
        System.out.println(findDublicat(arr5x5));
        System.out.println(isMagicSquare(arr5x5));
    }

    public static <T> void printArr(T[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void printCustom(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[4][i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][4] + ", ");
        }
    }

    public static String[][] fillGrid(int size) {
        String[][] arr = new String[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (x == y || size - y - 1 == x) {
                    arr[x][y] = "X ";
                } else {
                    arr[x][y] = "  ";
                }
            }
        }
        return arr;
    }

    public static int countElements(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!isContainWhithIgnor(arr, arr[i][j], j, i)) ++count;
            }
        }
        return count;
    }

    public static boolean isContainWhithIgnor(int[][] arr, int item, int arrJ, int arrI) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                if (arr[i][j] == item && (j != arrJ || i != arrI) && (i <= arrI && j < arrJ)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findDublicat(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isContainWhithIgnor(arr, arr[i][j], j, i)) return arr[i][j];
            }
        }
        return -1;
    }

    public static boolean isMagicSquare(int[][] arr) {
        int val = sumLine(arr, 0);

        for (int i = 1; i < arr.length; i++) {
            if (sumLine(arr, i) != val) return false;
        }
        for (int j = 0; j < arr[0].length; j++) {
            if (sumColumn(arr, j) != val) return false;
        }
        int sumDiagonal = 0;
        for (int i = 0; i<arr.length;i++)
        {
            sumDiagonal+=arr[i][i];
        }
        if (sumDiagonal!=val) return false;
        sumDiagonal = 0;
        for (int i = 0; i<arr.length;i++)
        {
            sumDiagonal+=arr[i][arr.length-1-i];
        }
        if (sumDiagonal!=val) return false;
        return true;
    }

    public static int sumLine(int[][] arr, int line) {
        int sum = 0;
        for (int i = 0; i < arr[line].length; i++) {
            sum += arr[line][i];
        }
        return sum;
    }

    public static int sumColumn(int[][] arr, int column) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][column];
        }
        return sum;
    }

}
