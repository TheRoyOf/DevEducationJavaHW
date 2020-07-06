package com;

public class Node {
    Object item;
    Node next;
    Node prev;

    Node(Object  element) {
        this.item = element;
    }

    Node(Node prev, Object  element, Node next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

}
