package com.techarha.training.dp;

import java.time.LocalDateTime;
import java.time.temporal.ValueRange;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a Vector V and W, representing the Value and Weight of the items respectively,
 * and One Knapsack with weight K.
 * Find the total number of items we can pick, such that the weight of items picked is
 * minimum while the value of items is maximum.
 *
 */
public class Knapsack {
    public static void main(String[] args) {
//        int[] values = { 7, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12 };
//        int[] weight = { 3, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10 };
        int[] values = { 7, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 2, 1, 6, 12, 6, 12 };
        int[] weight = { 3, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 1, 2, 4, 10, 4, 10 };
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(knapsackMemo(values, weight, 0, 69, memo));
        System.out.println(knapsackBasic(values, weight, 0, 69));
    }

    // basic solution
    private static int knapsackBasic(int[] value, int[] weights, int index, int wAllowed) {
        if(index >= value.length) {
            return 0;
        }
        if(wAllowed < weights[index]) {
            return knapsackBasic(value, weights, index + 1, wAllowed);
        }else {
            return Integer.max(knapsackBasic(value, weights, index + 1, wAllowed),
                    value[index] + knapsackBasic(value, weights, index + 1, wAllowed - weights[index]));
        }

    }

    // Enhanced Recursive Memoize Algo
    private static int knapsackMemo(int[] value, int[] weights, int index, int wAllowed, Map<String, Integer> memo) {
        if(index >= value.length) {
            return 0;
        }
        if(memo.containsKey(wAllowed+"-"+index)) {
            return memo.get(wAllowed+"-"+index);
        }
        if(wAllowed < weights[index]) {
            memo.put(wAllowed+"-"+index,knapsackMemo(value, weights, index + 1, wAllowed, memo));
            return memo.get(wAllowed+"-"+index);
        }else {
            memo.put(wAllowed+"-"+index, Integer.max(knapsackMemo(value, weights, index + 1, wAllowed, memo),
                    value[index] + knapsackMemo(value, weights, index + 1, wAllowed - weights[index], memo)));
            return memo.get(wAllowed+"-"+index);
        }
    }

}
