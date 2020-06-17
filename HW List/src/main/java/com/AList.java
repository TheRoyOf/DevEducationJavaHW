package com;

import com.interfaces.List;

import java.util.Arrays;
import java.util.Objects;

public class AList implements List {

    private Object[] array = new Object[10];
    private int lastIndex = 0;

    public Object get(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public boolean add(Object item) {
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2);
        }
        array[lastIndex++] = item;
        return true;
    }

    public boolean addFirst(Object item) {
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2);
        }

        for (int i = ++lastIndex; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        return true;
    }

    public boolean add(int index, Object item) {
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2);
        }

        for (int i = ++lastIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        return true;
    }

    public boolean remove(Object item) {
        for (int i = 0; i < lastIndex; i++) {
            if (array[i].equals(item)) {
                array[i] = null;

                for (int j = i; j < lastIndex; j++) {
                    array[j] = array[j + 1];
                }
                array[lastIndex] = null;
                --lastIndex;
            }
        }
        return true;
    }

    public Object remove(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object temp = array[index];
        for (int i = index; i < lastIndex; i++) {
            array[i] = array[i + 1];
        }
        array[lastIndex] = null;
        --lastIndex;
        return temp;
    }

    public void clear() {
        array = new Object[10];
        lastIndex = 0;
    }

    public boolean contains(Object item) {
        for (Object o : array) {
            if (item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return lastIndex;
    }

    public boolean isEmpty() {
        return array[0] == null;
    }


    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AList aList = (AList) o;
        return lastIndex == aList.lastIndex &&
                Arrays.equals(array, aList.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lastIndex);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
