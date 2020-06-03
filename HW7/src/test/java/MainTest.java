import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void amountOfRepeats() {
        String str = "kraken";
        int expected = 2;
        assertEquals(expected, Main.amountOfRepeats(str,"k"));
    }

    @org.junit.jupiter.api.Test
    void getStringItem() {
        List<String> expected = new ArrayList<String>(Arrays.asList("T","e","s","t"));
        assertEquals(expected,Main.getStringItem("Test"));
    }

    @org.junit.jupiter.api.Test
    void invert() {
        assertEquals("tseT", Main.invert("Test"));
    }

    @org.junit.jupiter.api.Test
    void removeBefore() {
        assertEquals("ing", Main.removeBefore("String",0,3));
    }

    @org.junit.jupiter.api.Test
    void isUniqueSimbols() {
        List<String> expected = new ArrayList<String>(Arrays.asList("Kraken", "utrhv", "dot"));
        assertEquals(expected, Main.isUniqueSimbols("Kraken utrhv dot"));
    }

    @org.junit.jupiter.api.Test
    void maxLength() {
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("Kraken", "utrhv", "dot"));
        assertEquals("Kraken", Main.maxLength(test));
    }

    @org.junit.jupiter.api.Test
    void minLength() {
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("Kraken", "utrhv", "dot"));
        assertEquals("dot", Main.minLength(test));

    }

    @org.junit.jupiter.api.Test
    void isPalindrome() {
        assertTrue(Main.isPalindrome("tetet"));
        assertFalse(Main.isPalindrome("test"));
    }
}