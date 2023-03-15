/*
 * Click `Run` to execute the snippet below!
 */

package my.coderpad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

class Coins {

    public static void main(String[] args) {

        Set<String> coinsUK = Set.of("1p", "10p", "100p", "2p", "20p", "200p", "5p", "50p");

        test(1, coinsUK, 77, 4);
        test(2, coinsUK, 599, 9);
        test(3, coinsUK, 1, 1);
        test(4, coinsUK, 11, 2);
    }

    // Method to calculate the minimum number of coins required to
    // give change (money) for a given amount
    // change: this is the amount of change needed to be given
    // coins: a set of coins available to make the change with

    static Integer findMinimumNumberOfCoinsForChange(Integer change, Set<String> coins) {
        // TODO - implement this method
        var sortedCoins = coins.stream().map((t) -> Integer.parseInt(t.replace("p", "")))
                .sorted(Comparator.reverseOrder()).toList();

        // System.out.print(sortedCoins);

        var runningAmount = change;
        var runningChange = new ArrayList<Integer>();
        for (Integer coin : sortedCoins) {
            while (runningAmount - coin >= 0) {
                runningAmount = runningAmount - coin;


                System.out.println(coin);
                runningChange.add(coin);

            }
        }


        return runningChange.size();
    }

    static void test(Integer testNumber, Set<String> coins, Integer change, Integer expected) {

        Integer actual = findMinimumNumberOfCoinsForChange(change, coins);

        System.out.println("------------------------------------");
        System.out.println(" Test:     " + testNumber);
        System.out.println(" Expected: " + expected.toString());
        System.out.println(" Actual:   " + actual.toString());
        if (actual.equals(expected)) {
            System.out.println(" PASS");

        } else {
            System.out.println(" FAIL");

        }
    }


}