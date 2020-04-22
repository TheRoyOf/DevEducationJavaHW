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
        switch (taskId)
        {
            case 1:
                return true;
            case 2:
                if ((x == 1 || x == 7) || (y == 1 || y == 7))
                {
                    return true;
                }
                break;
            case 3:
                int offset = 0;
                if (x == 1 || y == 1 || (7-y == x-1))
                {
                    return true;
                }
                break;
            case 4:
                if (x == 1 || y == 7 || y == x)
                {
                    return true;
                }
                break;
            case 5:
                if (x == 7 || y == 7 || (7-y == x-1))
                {
                    return true;
                }
                break;
            case 6:
                if (x == 7 || y == 1 || y == x)
                {
                    return true;
                }
                break;
            case 7:
                if (x == y || 7-y == x-1)
                {
                    return true;
                }
                break;
            case 8:
                if (y == 1 || (x == y || 7-y == x-1) && y <= 4)
                {
                    return true;
                }
                break;
            case 9:
                if (y == 7 || (x == y || 7-y == x-1) && y >= 4)
                {
                    return true;
                }
                break;
            case 10:
                if (x == 1 || (x == y || 7-y == x-1) && x <= 4)
                {
                    return true;
                }
                break;
            case 11:
                if (x == 7 || (x == y || 7-y == x-1) && x >= 4)
                {
                    return true;
                }
                break;
        }
        return false;
    }

}
