import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_sortMirror() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expArr = {2, 9, 4, 7, 6, 5, 8, 3, 10, 1};
        assertArrayEquals(expArr,Main.sortMirror(arr));
    }

    @Test
    void TEST_sortEven() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expArr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        assertArrayEquals(expArr,Main.sortEven(arr));
    }

    @Test
    void TEST_task4() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expArr = {-1, 7, 1, 2, 3, 39, 5, 67, 7, 0};
        Main.task4(arr);
        assertArrayEquals(expArr,arr);
    }

    @Test
    void TEST_medianElement() {
        int[] arr = {-1, 7, 1, 2, 3, 39, 5, 67, 7, 0};
        assertEquals(7,Main.medianElement(arr));
    }

    @Test
    void TEST_max5() {
        int[] arr = {-1, 7, 1, 2, 3, 39, 5, 67, 7, 0};
        int[] expArr = {3, 39, 5, 67, 7};
        assertArrayEquals(expArr,Main.Max5(arr));
    }

    @Test
    void TEST_shiftSymbol() {

        int[] arr = {-1, 7, 1, 2, 3, 39, 5, 67, 7, 0};
        assertEquals(1,Main.shiftSymbol(arr));
    }

    @Test
    void TEST_inLine3() {
        int[] arr = {-1, 7, 1, 2, 3, 39, 5, 67, 7, 0};
        int[] expArr = {-1, 7, 1, 2, 3, 39};
        assertArrayEquals(expArr,Main.inLine3(arr));
    }

    @Test
    void TEST_task9() {
        int[] arr = {0, -1, 3, -3, 5, -9, 34, 2};
        int[] expArr = {-1, -3, -9, 0, 3, 5, 34, 2};
        assertArrayEquals(expArr,Main.task9(arr));
    }
}