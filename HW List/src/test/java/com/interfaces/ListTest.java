package com.interfaces;

import com.AList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    List testList = new AList();

    @BeforeEach
    void init() {
        testList.clear();
        for (int i = 0; i < 12; i++) {
            testList.add(new Object());
        }
    }

    @Test
    void TEST_get() {
        class Test{
            boolean test;
        }
        Test testObject = new Test();
        testList.add(testObject);
        assertEquals(testObject, testList.get(testList.size()-1));
    }

    @Test
    void TEST_add() {
        assertTrue(testList.add(new Object()));
    }

    @Test
    void TEST_addFirst() {
        assertTrue(testList.addFirst(new Object()));
    }

    @Test
    void TEST_indexAdd() {
        assertTrue(testList.add(2, new Object()));
    }

    @Test
    void TEST_remove() {
        assertTrue(testList.remove(new Object()));
    }

    @Test
    void TEST_indexRemove() {
        class Test{
            boolean test;
        }
        Test testObject = new Test();
        testList.add(testObject);
        assertEquals(testObject, testList.remove(testList.size()-1));
    }

    @Test
    void TEST_clear() {
        testList.clear();
        assertEquals(new AList(), testList);
    }

    @Test
    void TEST_contains() {
        class Test{
            boolean test;
        }
        Test testObject = new Test();
        testList.add(testObject);
        assertTrue(testList.contains(testObject));
    }

    @Test
    void TEST_size() {
        assertEquals(12, testList.size());
    }

    @Test
    void TEST_isEmpty() {
        assertTrue(new AList().isEmpty());
    }
}