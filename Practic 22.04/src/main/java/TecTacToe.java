import java.util.Scanner;

public class TecTacToe
{
    private static boolean sessionActive = true;

    public static int[][] grid =
            {{-1,-1,-1},
            {-1,-1,-1},
            {-1,-1,-1}};

    public static void init()
    {
        int activePlayer = 1;

        showGrid();
        while (sessionActive)
        {

            System.out.println("Player " + activePlayer);
            select(activePlayer);
            showGrid();
            if (findFullLine(activePlayer))
            {
                sessionActive = false;
            }
            else if(noMoreStep())
            {
                reloadGrid();
                activePlayer = setNextPlayer(activePlayer);
                System.out.println();
                System.out.println("Reload grid");
                System.out.println();
                showGrid();
            }
            else
            {
                activePlayer = setNextPlayer(activePlayer);
            }
        }
        winGame(activePlayer);
    }

    private static void reloadGrid()
    {
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                grid[x][y] = -1;
            }
        }
    }

    private static boolean noMoreStep()
    {
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                if (grid[x][y] == -1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static int enterValue(String str)
    {
        System.out.println(str);
        return new Scanner(System.in).nextInt();
    }

    private static void showGrid()
    {
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                if (grid[x][y] == -1)
                {
                    System.out.print("( )");
                }
                else if (grid[x][y] == 1)
                {
                    System.out.print("(X)");
                }
                else if (grid[x][y] == 2)
                {
                    System.out.print("(O)");
                }
            }
            System.out.println();
        }
    }

    private static void winGame(int activePlayer)
    {
System.out.println("Player " + activePlayer + " win!");
    }

    private static void select (int playerId)
    {
        while (true)
        {
            System.out.println("Player " + playerId);
            int x = enterValue("Enter X: ")-1;
            int y = enterValue("Enter Y: ")-1;

            if (grid[x][y] == -1)
            {
                grid[x][y] = playerId;
                break;
            }
            else
            {
                System.out.println("Cell is not empty!");
            }
        }
    }

    private static boolean findFullLine (int playerId) // Осторожно!!! Наговнокожено в 3:00, живой вариант но возможно лучше.
    {
        //проверяем горизонтали
        if (grid [1][0] != -1 && grid[0][0] == playerId && grid [1][0] == playerId && grid[2][0] == playerId)
        {
            return true;
        }
        else if (grid [1][1] != -1 && grid[0][1] == playerId && grid [1][1] == playerId && grid[2][1] == playerId)
        {
            return true;
        }
        else if (grid [1][2] != -1 && grid[0][2] == playerId && grid [1][2] == playerId && grid[2][2] == playerId)
        {
            return true;
        }
        //проверяем вертикали
        else if (grid [0][1] != -1 && grid[0][0] == playerId && grid [0][1] == playerId && grid[0][2] == playerId)
        {
            return true;
        }
        else if (grid [1][1] != -1 && grid[1][0] == playerId && grid [1][1] == playerId && grid[1][2] == playerId)
        {
            return true;
        }
        else if (grid [2][1] != -1 && grid[2][0] == playerId && grid [2][1] == playerId && grid[2][2] == playerId)
        {
            return true;
        }
        //проверяем диагонали
        else if (grid [1][1] != -1 && grid[0][0] == playerId && grid [1][1] == playerId && grid[2][2] == playerId)
        {
            return true;
        }
        else if (grid [1][1] != -1 && grid[0][2] == playerId && grid [1][1] == playerId && grid[2][0] == playerId)
        {
            return true;
        }
        return false;
    }

    private static int setNextPlayer(int activePlayer)
    {
        switch (activePlayer)
        {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

}
