package com.techarha.training.GeneralQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * How many ways can we provide coin change, provided we have coins of certain denominations.
 *
 */
public class CoinChange {

    //Denominations should be reverse sorted
    private static long coinPaths(int moneyNeeded, int[] denomination, int denominationIndex) {
        if(moneyNeeded <= 0) {
            return 1;
        }

        if(denominationIndex >= denomination.length) {
            return 0;
        }

        int initialAmount = 0;
        long path = 0;
        while(initialAmount <= moneyNeeded ) {
            int moneyLeft = moneyNeeded - initialAmount;
            path += coinPaths(moneyLeft, denomination, denominationIndex + 1);
            initialAmount += denomination[denominationIndex];
        }
        return path;
    }

    public static void main(String[] args) {
        System.out.println("" + coinPaths(5, new int[]{2, 1}, 0));
    }
}
