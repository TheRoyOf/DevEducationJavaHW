import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_isNumeric()
    {
        assertTrue(Main.isNumeric("23"));
        assertFalse(Main.isNumeric("aA"));
    }

    @Test
    void TEST_parseValue()
    {
        Value test_value = new Value("2");
        test_value.action = "+";
        assertEquals(test_value.action,Main.ParseValue("2+ 2").action);
        assertEquals(test_value.val_A,Main.ParseValue("2+ 2").val_A);
        assertEquals(test_value.val_B,Main.ParseValue("2+ 2").val_B);
    }

    @Test
    void TEST_calc()
    {
        Value test_value = new Value("2");
        test_value.action = "+";
        assertEquals("4",Main.Calc(test_value));
    }
}