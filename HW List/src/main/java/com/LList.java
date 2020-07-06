package com;

import com.interfaces.List;

public class LList<T> implements List<T> {

    Node head;

    private int size = 0;

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; ++i)
        {
            if(temp.next != null)
            {
                temp = temp.next;
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
        return temp.item;
    }

    public boolean add(T item) {
        if (head != null) {
            head = new Node(item);
        } else {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    temp.next = new Node(item);
                    temp.next.prev = temp;
                    ++size;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addFirst(T item) {
        Node temp = head;
        head = new Node(item);
        head.next = temp;
        temp.prev = head;
        ++size;
        return true;
    }

    public boolean add(int index, T item) {
        Node temp = head;
        for (int i = 0; i != index; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        Node prev = temp;
        Node next = temp.next;

        temp = new Node(item);

        prev.next = temp;
        temp.prev = prev;

        if (next != null) {
            next.prev = temp;
            temp.next = next;
        }
        ++size;
        return true;
    }

    public boolean remove(T item) {
        Node temp = head;
        while (temp != null)
        {
            if (temp.item.equals(item))
            {
                Node prev = temp.prev;
                temp = temp.next;
                temp.prev = prev;
                --size;
            }
            else
            {
                temp = temp.next;
            }
        }
        return true;
    }

    public Object remove(int index) {
        Node temp = head;
        for (int i = 0; i < index; ++i)
        {
            if(temp.next != null)
            {
                temp = temp.next;
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        return temp.item;
    }

    public void clear() {
        while (true) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = null;
                size = 0;
                return;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object item) {
        Node temp = head;
        while (temp != null)
        {
            if (temp.item.equals(item))
            {
                return true;
            }
            else
            {
                temp = temp.next;
            }
        }
        return false;
    }


}
