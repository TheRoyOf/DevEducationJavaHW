package com;

import com.interfaces.List;

import java.util.Arrays;
import java.util.Objects;

public class RList<T> implements List<T> {

    private RListWrapper[] array = new RListWrapper[10];

    private int lastIndex = 0;

    public RListWrapper<T> get(int index) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public T getElement(int index) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index].getElement();
    }

    public boolean add(T item) {
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2); // капелька магических чисел
        }
        array[lastIndex++].setElement(item);
        if (array.length > 1)
        {
            array[lastIndex-1].setNextElement(array[lastIndex]);
        }
        return true;
    }

    public boolean addFirst(T item) {
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2);
        }

        for (int i = ++lastIndex; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0].setElement(item);
        if(array.length > 1)
        {
            array[0].setNextElement(array[1]);
        }
        return true;
    }

    public boolean add(int index, T item) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (lastIndex == array.length) {
            resize(array.length * 3 / 2);
        }

        for (int i = ++lastIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index].setElement(item);
        return true;
    }

    public boolean remove(T item) {
        for (int i = 0; i < lastIndex; i++) {
            if (array[i].equals(item)) {
                array[i] = null;
                for (int j = i; j < lastIndex; j++) {
                    array[j] = array[j + 1];
                }
                array[lastIndex] = null;
                --lastIndex;
                if (lastIndex > 0)
                {
                    array[i-1].setNextElement(array[i]);
                }
            }
        }
        return true;
    }

    public Object remove(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        RListWrapper temp = array[index];
        for (int i = index; i < lastIndex; i++) {
            array[i] = array[i + 1];
        }
        array[lastIndex] = null;
        --lastIndex;
        if (lastIndex > 0)
        {
            array[index-1].setNextElement(array[index]);
        }
        return temp.getElement();
    }

    public void clear() {
        array = new RListWrapper[10];
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
        RListWrapper[] newArray = new RListWrapper[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i].setElement(array[i].getElement());
        }
        array = newArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RList rList = (RList) o;
        return lastIndex == rList.lastIndex &&
                Arrays.equals(array, rList.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lastIndex);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}