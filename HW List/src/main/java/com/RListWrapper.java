package com;

import java.util.Objects;

public class RListWrapper<T> {
    private T obj;
    private RListWrapper<T> nextElement;

    public Object getElement() {
        return obj;
    }

    public RListWrapper<T> getNext() {
        return nextElement;
    }

    public void setElement(T obj) {
        this.obj = obj;
    }

    public void setNextElement(RListWrapper<T> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RListWrapper<?> that = (RListWrapper<?>) o;
        return obj.equals(that.obj) &&
                nextElement.equals(that.nextElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj, nextElement);
    }
}
