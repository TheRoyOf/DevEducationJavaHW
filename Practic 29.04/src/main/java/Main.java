import java.util.Arrays;

public class Main
{
    public static void main(String[]args)
    {
        int[][] arr5x5={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        print(arr5x5);
    }

    public static void print(int[][] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[4][i] + ", ");
        }
        System.out.println();
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i][4] + ", ");
        }
    }

    public static void fillGrid(int[][]arr)
    {
        for (int y = 1; y <= 7; y++) {
            for (int x = 1; x <= 7; x++) {
                if (x == y || 7-y == x-1)
                {
                    arr[x][y]='x';
                }
                else
                {
                    arr[x][y]=' ';
                }
            }
        }
    }

    public static int countElements(int[][]arr)
    {
        int count = 0;
        for (int y = 1; y <= 7; y++) {
            for (int x = 1; x <= 7; x++) {
                if (!isContain(arr,arr[x][y],x,y)) ++count;
            }
        }
        return count;
    }

    public static boolean isContain(int[][]arr, int item, int arrX, int arrY)
    {
        for (int y = 1; y <= 7; y++) {
            for (int x = 1; x <= 7; x++) {
                if (arr[x][y]==item && x!=arrX && y!=arrY) return true;
            }
        }
        return false;
    }

    

}
