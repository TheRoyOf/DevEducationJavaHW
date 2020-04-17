import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class MainTest
{

    double delta = 0.001;

    Main _Main;
    @Test
    void TEST_MathAction_Sum()
    {
        int testVal_A = 20;
        double testVal_B = 5;
        double valExpect = 25;
        assertEquals(_Main.MathAction(Main.EAction.Sum,testVal_A,testVal_B),valExpect,delta);
    }

    @Test
    void TEST_MathAction_Div()
    {
        int testVal_A = 20;
        double testVal_B = 5;
        double valExpect = 4;
        assertEquals(_Main.MathAction(Main.EAction.Div,testVal_A,testVal_B),valExpect,delta);
    }

    @Test
    void TEST_MathAction_Sub()
    {
        int testVal_A = 20;
        double testVal_B = 5;
        double valExpect = 15;
        assertEquals(_Main.MathAction(Main.EAction.Sub,testVal_A,testVal_B),valExpect,delta);
    }

    @Test
    void TEST_MathAction_Mul()
    {
        int testVal_A = 20;
        double testVal_B = 5;
        double valExpect = 100;
        assertEquals(_Main.MathAction(Main.EAction.Mul,testVal_A,testVal_B),valExpect,delta);
    }

    @Test
    void TEST_MathAction_Mod()
    {
        int testVal_A = 4;
        double testVal_B = 3;
        double valExpect = 1;
        assertEquals(_Main.MathAction(Main.EAction.Mod,testVal_A,testVal_B),valExpect,delta);
    }
}
