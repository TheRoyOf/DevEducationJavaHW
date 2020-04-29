import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(fillRandom(100)));
        System.out.println(Arrays.toString(sortMirror(arr)));
        System.out.println(Arrays.toString(sortEven(arr)));
        task4(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(medianElement(arr));
        System.out.println(Arrays.toString(Max5(arr)));
        System.out.println(shiftSymbol(arr));
        System.out.println(Arrays.toString(inLine3(arr)));
        arr = new int[]{0, -1, 3, -3, 5, -9, 34, 2};
        System.out.println(Arrays.toString(task9(arr)));

    }

    public static int[] sortMirror(int[] arr) {
        int[] sortArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sortArr[i - 1] = arr[i];
            } else {
                sortArr[arr.length - 1 - i] = arr[i];
            }
        }
        return sortArr;
    }

    public static int[] sortEven(int[] arr) {
        int[] sortArr = new int[arr.length];

        int pointEven = 0;
        int pointUneven = 0;
        int pointZero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shiftArr(sortArr, pointZero);
                sortArr[pointZero] = arr[i];
                ++pointZero;
            } else if (arr[i] % 2 != 0) {
                shiftArr(sortArr, pointUneven);
                sortArr[pointUneven] = arr[i];
                ++pointUneven;
                ++pointZero;
            } else {
                shiftArr(sortArr, pointEven);
                sortArr[pointEven] = arr[i];
                ++pointEven;
                ++pointUneven;
                ++pointZero;
            }
        }
        return sortArr;
    }

    public static void shiftArr(int[] arr, int startIndex) {
        for (int i = arr.length - 2; i >= startIndex; i--) {
            arr[i + 1] = arr[i];
            if (i == startIndex) {
                arr[i] = 0;
            }
        }
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

    public static void task4(int[] arr) {

        int A = 3;
        int B = 2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 4) {
                arr[i] = arr[i] / 2;
            } else if (arr[i] % 10 == 0) {
                arr[i] = 0;
            } else if (i % 2 == 0) {
                arr[i] = arr[i] - B;
            } else if (arr[i] % 2 == 0) {
                arr[i] = (int) Math.pow(arr[i], 2) + A;
            } else {
                arr[i] = arr[i] * 2;
            }
        }
    }

    public static int medianElement(int[] arr) {
        int sum = 0;
        int itemVal;
        int prevItem = 0;
        int prevItemValue = Integer.MAX_VALUE;
        for (int i : arr) {
            sum = sum + i;
        }
        sum = sum / arr.length;

        for (int value : arr) {
            itemVal = Math.abs(sum - value);
            if (itemVal < prevItemValue) {
                prevItem = value;
                prevItemValue = itemVal;
            }
        }
        return prevItem;
    }

    public static int[] Max5(int[] arr) {
        int[] activeArr = new int[5];
        int activeMax;
        int[] prevArr = new int[5];
        int prevMax = 0;

        for (int i = 0; i < arr.length; i++) {
            activeMax = 0;
            for (int j = 0; j < 5; j++) {
                if (i + j >= arr.length) break;
                activeArr[j] = arr[i + j];
                activeMax += activeArr[j];
            }
            if (activeMax > prevMax)
            {
                prevMax = activeMax;
                prevArr = activeArr.clone();
            }
        }
        return prevArr;
    }

    public static int shiftSymbol(int[]arr)
    {
        int counter =0;
        for (int i = 1;i<arr.length;i++)
        {
            if ((arr[i-1]>0 && arr[i]<0)||(arr[i-1]<0 && arr[i]>0))
            {
                counter++;
            }
        }
        return counter;
    }

    public static int[] inLine3(int[]arr)
    {
        int[]rez = new int[0];
        for (int i = arr.length-2; i>0;i--)
        {
            if(arr[i-1]< arr[i] && arr[i]>arr[i+1])
            {
                rez = new int[i-1];
                for (int j = 0; j<i-1; j++)
                {
                    rez[j]=arr[j];
                }
                break;
            }
        }
        return rez;
    }

    public static int[] task9(int[]arr)
    {
        int countNegative = 0;
        int countPositive = 0;
        int[]rezNegative = new int[arr.length];
        int[]rezPozitive = new int[arr.length];
        int[]rez = new int[arr.length];

        for (int i = 0; i<arr.length;i++)
        {
            if (arr[i]<0)
            {
                rezNegative[countNegative] = arr[i];
                ++countNegative;
            }
            else
            {
                rezPozitive[countPositive] = arr[i];
                ++countPositive;
            }
        }
        System.arraycopy(rezNegative,0,rez,0,countNegative);
        System.arraycopy(rezPozitive,0,rez,countNegative,countPositive);
        return rez;
    }
}