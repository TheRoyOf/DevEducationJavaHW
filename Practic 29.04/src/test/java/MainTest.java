import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_fillGrid() {
        String[][]expected = {
                {"X ","  ","  ","  ","X "},
                {"  ","X ","  ","X ","  "},
                {"  ","  ","X ","  ","  "},
                {"  ","X ","  ","X ","  "},
                {"X ","  ","  ","  ","X "}};
        assertArrayEquals(expected, Main.fillGrid(5));
    }

    @Test
    void TEST_countElements() {
        int[][] arr5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 22, 24, 25}};
        assertEquals(24,Main.countElements(arr5x5));
    }

    @Test
    void TEST_findDublicat() {
        int[][] arr5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 22, 24, 25}};
        assertEquals(22,Main.findDublicat(arr5x5));
    }

    @Test
    void TEST_isMagicSquare() {
        int[][] arr5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 22, 24, 25}};
        assertFalse(Main.isMagicSquare(arr5x5));

        int[][] magic = {
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 6}};
        assertTrue(Main.isMagicSquare(magic));
    }
}