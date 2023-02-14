package my.collections;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ArrayListDemo {

    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        IntStream.range(0, 100).forEachOrdered(list::add);


        // get(int index) is O(1). Main benefit of ArrayListDemo<E>
        list.get(50);

        // add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
        list.add(101);



        // add(int index, E element) is O(n) (with n/2 steps on average)
        list.add(8, 199);

        //remove(int index) is O(n) (with n/2 steps on average)
        list.remove(1);

    }
}
