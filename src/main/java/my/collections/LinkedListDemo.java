package my.collections;

import java.util.stream.IntStream;

public class LinkedListDemo {

    public static void linkedListDemo() {
        /**
         * A LinkedList consumes more memory than an ArrayList because of every node in a LinkedList stores two references,
         * one for its previous element and one for its next element, whereas ArrayList holds only data and its index.
         */
        var linkedList = new java.util.LinkedList<Integer>();

        /**
         * add(int index, E element) is O(n) (with n/4 steps on average),
         * but O(1) when index = 0 or index = list.size() - 1 (in this case, you can also use addFirst() and addLast()/add()).
         * One of the main benefits of LinkedList<E>
         */
        IntStream.range(0, 101).forEachOrdered(linkedList::add);
        /**
         * Same with remove
         */
        linkedList.removeLast();

        /**
         * get(int index) is O(n) (with n/4 steps on average),
         * but O(1) when index = 0 or index = list.size() - 1 (in this case, you can also use getFirst() and getLast()).
         * One of the main benefits of LinkedList<E>
         */
        linkedList.get(0);


    }
}
