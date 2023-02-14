package my.collections;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    int size = 0;

    /**
     * Pointer to first node.
     */
    Node<E> first;

    /**
     * Pointer to last node.
     */
    Node<E> last;


    public void add(E item) {
        if (first == null) {
            // First element
            this.first = new Node<>(null, item, null);
            this.last = first;
            this.size = 1;
        } else {
            var lastNode = new Node<>(this.last, item, null);
            this.last.next = lastNode;
            this.last = lastNode;
            this.size++;
        }
    }

    E findNext(E item) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item.equals(item)) {
                return x.next.item;
            }
        }
        return null;
    }

    E findPrev(E item) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item.equals(item)) {
                return x.prev.item;
            }
        }
        return null;
    }

    void addFirst(E item) {
        var currentFirst = this.first;
        var newNode = new Node<>(null, item, currentFirst);
        currentFirst.prev = newNode;
        this.first = newNode;
    }

    void insertAfter(E currentItem, E item) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == currentItem) {
                x.next = new Node<>(x, item, x.next);
            }
        }
    }

    List<E> toItems() {
        var list = new ArrayList<E>();
        for (Node<E> x = first; x != null; x = x.next) {
            list.add(x.item);
        }
        return list;
    }

    public static void main(String[] args) {
        var myList = new MyLinkedList<>();
        myList.add("Hello");
        myList.add("Goodbye");
        myList.add("Cow");
        myList.add("Dog");
        myList.add("Cat");
        System.out.println(myList.size);
        System.out.println(myList.first);
        System.out.println(myList.last);
        System.out.println(myList.last.next);

        System.out.println(myList.findNext("Cow"));
        System.out.println(myList.findPrev("Cow"));

        // Add first
        myList.addFirst("Greetings");
        System.out.println(myList.size);
        System.out.println(myList.toItems());

        myList.insertAfter("Cow", "Pig");
        System.out.println(myList.toItems());


    }


}


