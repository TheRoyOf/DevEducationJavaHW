import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_absoluteDiff() {
        assertEquals(16,Main.AbsoluteDiff(5),0.0001);
    }

    @Test
    void TEST_removeIndex() {
        assertEquals("tet",Main.RemoveIndex("test",2));
    }

    @Test
    void TEST_addLast() {
        assertEquals("ttestt",Main.AddLast("test"));
    }

    @Test
    void TEST_isHi() {
        assertTrue(Main.isHi("hi world"));
        assertFalse(Main.isHi("world hi"));
    }

    @Test
    void TEST_containsBetween() {
        assertTrue(Main.containsBetween("eteste"));
        assertFalse(Main.containsBetween("test"));
    }

    @Test
    void TEST_parseNthEl() {
        assertEquals("ts", Main.parseNthEl("test",2));
    }

    @Test
    void TEST_changeLastFirst() {
        assertEquals("rest stt", Main.changeLastFirst("test str"));
    }
}