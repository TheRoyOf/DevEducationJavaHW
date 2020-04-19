import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

class MainTest {

    @Test
    void TEST_maxValue() {
        ArrayList<Integer> testedList = new ArrayList<Integer>();
        int maxVal = 9999;
        testedList.add(1);
        testedList.add(3);
        testedList.add(5);
        testedList.add(maxVal);

        assertEquals(maxVal, Main.MaxValue(testedList));
    }

    @Test
    void TEST_minValue() {
        ArrayList<Integer> testedList = new ArrayList<Integer>();
        int minVal = 1;
        testedList.add(45);
        testedList.add(78);
        testedList.add(9);
        testedList.add(minVal);

        assertEquals(minVal, Main.MinValue(testedList));
    }

    @Test
    void TEST_sumValue() {
        ArrayList<Integer> testedList = new ArrayList<Integer>();
        testedList.add(1);
        testedList.add(3);
        testedList.add(5);

        assertEquals(9,Main.SumValue(testedList));
    }

    @Test
    void TEST_averageValue() {
        ArrayList<Integer> testedList = new ArrayList<Integer>();
        testedList.add(1);
        testedList.add(3);
        testedList.add(5);

        assertEquals(5, Main.MaxValue(testedList));
    }

    @Test
    void TEST_daysInEar() {
        assertEquals(366, Main.DaysInEar(2020));
    }

    @Test
    void TEST_splitString() {
        assertEquals(8, Main.SplitString("1474").even_sum);
        assertEquals(2, Main.SplitString("1474").even);
        assertEquals(2, Main.SplitString("1474").uneven);
    }
}