package my.collections;

import java.util.HashMap;

public class HashMapDemo {
    // Good article on hashmaps
    // https://www.geeksforgeeks.org/internal-working-of-hashmap-java/

    public static void main(String[] args) {
        // Back by an array of nodes.
        int capacity = 16;
        var map = new HashMap<String, String>(capacity);
        // Array of nodes is initialised (16 is the default size)
        // 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15
        map.put("Hello", "World");

        // The index is calculated using the below (should be 4)

        System.out.println(hashIndex("Hello", capacity));
        // HashMap is now this, each array element is a node
        // 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15
        //               |   |
        //               | Hello World|

        System.out.println(map.size());

        // If we add twos key with the same hash code they will be added to the same bucket of node
        map.put("Aa", "Aa");
        map.put("BB", "BB");
        System.out.println(hashIndex("Aa", capacity));
        System.out.println(hashIndex("BB", capacity));

        // HashMap is now this, Aa and BB are in the same bucket, linked via node.next (like linked list)
        //| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15
        //|   |           |   |
        //| Aa|           | Hello World|
        //| BB|


        // We can now get element
        map.get("Hello");
        // Calculate hash code of "hello".
        // Calculate index by using index method it will be 4.
        // Go to index 4 of the array and compare the first element’s key with the given key. If both are equals then return the value, otherwise, check for the next element if it exists.
        // In our case, it is found as the first element and the returned value is World.
    }

    static final int hashIndex(Object key, int cap) {
        int h;
        int n = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return (cap - 1) & n;
    }
}
