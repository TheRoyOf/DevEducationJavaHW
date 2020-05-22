import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void TEST_isNumeric()
    {
        assertTrue(Calculator.isNumeric("23"));
        assertFalse(Calculator.isNumeric("aA"));
    }

    @Test
    void TEST_parseValue()
    {
        Value test_value = new Value("2");
        test_value.action = "+";
        assertEquals(test_value.action,Calculator.ParseValue("2+ 2").action);
        assertEquals(test_value.val_A,Calculator.ParseValue("2+ 2").val_A);
        assertEquals(test_value.val_B,Calculator.ParseValue("2+ 2").val_B);
    }

    @Test
    void TEST_calc()
    {
        Value test_value = new Value("2");
        test_value.action = "+";
        assertEquals("4",Calculator.Calc(test_value));
    }
}