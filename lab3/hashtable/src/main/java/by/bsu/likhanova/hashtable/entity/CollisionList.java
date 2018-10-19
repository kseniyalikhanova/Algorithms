package by.bsu.likhanova.hashtable.entity;

public class CollisionList {
    static private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    CollisionList(int value) {
        first = new Node(value);
        last = first;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public void add(int value) {
        Node node = new Node(value);
        last.next = node;
        last = node;
        length++;
    }

    public boolean isContains(int value) {
        Node node = first;
        while (node != null) {
            if (node.value == value) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String elements = "{";
        Node node = first;
        while (node != null) {
            elements += "  " + node.value;
            node = node.next;
        }
        elements += " }";
        return elements;
    }
}
