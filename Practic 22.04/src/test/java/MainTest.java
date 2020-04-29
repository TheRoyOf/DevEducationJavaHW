import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_sumNumberElements() {
        assertEquals(Main.SumNumberElements(123), 6);
        assertEquals(Main.SumNumberElements(123456789), 45);
    }

    @Test
    void TEST_sumBunnyEars() {
        assertEquals(Main.SumBunnyEars(1, 100), 250);
    }

    @Test
    void TEST_isPairBracets() {
        assertTrue(Main.isPairBracets("(((a)))"));
        assertTrue(Main.isPairBracets("(a(a(a)a)a)"));
        assertFalse(Main.isPairBracets("(a(a)a)a)"));
    }

    @Test
    void TEST_removeBracets() {
        assertEquals(Main.RemoveBracets("(sds(+++(sds)---)dsd)"),"sds+++sds---dsd");
    }

    @Test
    void TEST_getPrimeNumbers() {
        ArrayList<Integer> testedList = Main.GetPrimeNumbers(1000);
        for (int item : testedList)
        {
            assertFalse((item != 2 && item != 3 && item != 5) && (item % 2 == 0 || item % 3 == 0 || item % 5 == 0));
        }
    }
}