import com.google.gson.Gson;

import java.util.ArrayList;
import com.google.gson.*;

public class Main {

    public static void main(String[] args)
    {

        for( int taskId = 1; taskId <= 11; taskId++)
        {
            System.out.println("Task # " + taskId);
            for (int y = 1; y <= 7; y++) {
                for (int x = 1; x <= 7; x++) {
                    if (isPrint(taskId,x,y))
                    {
                        System.out.print("X ");
                    }
                    else
                    {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println("______________");
        }


    }

    public static boolean isPrint(int taskId, int x, int y)
    {
        int maxLenght = 7;
        int mid = Math.round((float)maxLenght / 2);

        switch (taskId)
        {
            case 1:
                return true;
            case 2:
                    return ((x == 1 || x == maxLenght) || (y == 1 || y == maxLenght));
            case 3:
                    return (x == 1 || y == 1 || (maxLenght-y == x-1));
            case 4:
                    return (x == 1 || y == maxLenght || y == x);
            case 5:
                    return (x == maxLenght || y == maxLenght || (maxLenght-y == x-1));
            case 6:
                    return (x == maxLenght || y == 1 || y == x);
            case 7:
                    return (x == y || maxLenght-y == x-1);
            case 8:
                    return (y == 1 || (x == y || maxLenght-y == x-1) && y <= mid);
            case 9:
                    return (y == maxLenght || (x == y || maxLenght-y == x-1) && y >= mid);
            case 10:
                    return (x == 1 || (x == y || maxLenght-y == x-1) && x >= mid);
            case 11:
                    return (x == 7 || (x == y || maxLenght-y == x-1) && x <= mid);
        }
        return false;
    }
}
