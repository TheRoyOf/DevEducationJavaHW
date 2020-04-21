import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class TEST_HWTester
{
    @Test
    void TEST_CalcHipotenuse()
    {
        double d_op_A = 2.0;
        double d_op_B = 3.0;
        double d_exp = 3.605;

        int i_op_A = 2;
        int i_op_B = 3;
        double i_exp = 3.605;

        double delta = 0.001;

        assertEquals(Pifagor.CalcHipotenuse(d_op_A,d_op_B),d_exp,delta);
        assertEquals(Pifagor.CalcHipotenuse(i_op_A,i_op_B),i_exp,delta);
    }

    @Test
    void TEST_TestValue()
    {
        assertEquals(InputTester.TestValue(EMetod.IF,1),"1.0");
        assertEquals(InputTester.TestValue(EMetod.SWITCH,2),"2.0");
        assertEquals(InputTester.TestValue(EMetod.TERNAR,3),"3.0");
    }
}