import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

class MainTest {

    int[] arr = new int[]{1, 2, 3, 234, 23, 5, 432, 85, 72, 54, 12, 9, 45, 61, 384, 4, 989435, 34, 8, 46, 47, 6, 6};

    @Test
    void TEST_bubleSort() {
        int[] sortArr = new int[]{1, 2, 3, 4, 5, 6, 6, 8, 9, 12, 23, 34, 45, 46, 47, 54, 61, 72, 85, 234, 384, 432, 989435};
        assertArrayEquals(sortArr, Main.bubleSort(arr));
    }

    @Test
    void TEST_max() {
        assertEquals(989435,Main.Max(arr));
    }

    @Test
    void TEST_max3() {
        int[] testArr = new int[]{989435, 432, 384};
        assertArrayEquals(testArr,Main.Max3(arr));
    }

    @Test
    void TEST_reverse() {
        int[] testArr = new int[]{989435, 432, 384, 234, 85, 72, 61, 54, 47, 46, 45, 34, 23, 12, 9, 8, 6, 6, 5, 4, 3, 2, 1};
        int[] sortArr = new int[]{1, 2, 3, 4, 5, 6, 6, 8, 9, 12, 23, 34, 45, 46, 47, 54, 61, 72, 85, 234, 384, 432, 989435};
        assertArrayEquals(testArr,Main.reverse(sortArr));
    }

    @Test
    void TEST_reiteration() {
        int[] testArr = new int[]{6, 2};
        assertArrayEquals(testArr,Main.reiteration(arr));
    }

    @Test
    void TEST_fillMirrorArray() {
        int[] testArr = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(testArr,Main.fillMirrorArray(25));
    }
}