import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void TEST_squareRange() {
        int[]arr = {2, 4, 6, 8, 10, 9, 7, 5, 3, 1};
        int[]expArr = {4, 16, 36, 64};
        assertArrayEquals(expArr,Main.squareRange(arr,3,7));
    }

    @org.junit.jupiter.api.Test
    void TEST_diagonalIsLowThat() {
        int[][]arr2x = {{1,2,3},{4,5,6},{7,8,9}};
        assertTrue(Main.diagonalIsLowThat(arr2x,20));
        assertFalse(Main.diagonalIsLowThat(arr2x,10));
    }

    @org.junit.jupiter.api.Test
    void TEST_tester() {
        int[][]arr2x = {{1,2,3},{4,5,6},{7,8,9}};
        assertTrue(Main.tester(arr2x));
    }
}