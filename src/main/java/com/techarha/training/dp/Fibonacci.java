package com.techarha.training.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        String data = "helloworld";
        System.out.println(data.length());
        System.out.println(data.charAt(1));
//        System.out.println(new Fibonacci().findFibonacciValueMemoise(7, new HashMap<Integer, Integer>()));
//        System.out.println(new Fibonacci().findFinbonacciMemoiseBottomUpBetter(7));
    }

    // basic solution
    private Integer findFibonacciValue(Integer number) {
        if(number == 0) {
            return 0;
        }
        if(number == 1) {
            return 1;
        }
        Integer left = findFibonacciValue(number - 1);
        Integer right = findFibonacciValue(number - 2);
        return left + right;
    }

    // Enhanced Recursive Memoize Algo
    private Integer findFibonacciValueMemoise(Integer number, Map<Integer, Integer> memo) {
        if(memo.containsKey(number)) {
            return memo.get(number);
        }
        if(number == 0) {
            memo.put(0, 0);
            return memo.get(number);
        }
        if(number == 1) {
            memo.put(1, 1);
            return memo.get(number);
        }
        Integer left = findFibonacciValueMemoise(number - 1, memo);
        Integer right = findFibonacciValueMemoise(number - 2, memo);
        memo.put(number, left+right);
        return memo.get(number);
    }

    private Integer findFinbonacciMemoiseBottomUp(Integer number) {
        if(number == 0) return 0;
        if(number == 1) return 1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1,1);

        for (int i = 2; i <= number; i++) {
            Integer base = map.get(i-2);
            Integer previous = map.get(i-1);

            map.put(i, base+previous);
        }
        return map.get(number);
    }

    private Integer findFinbonacciMemoiseBottomUpBetter(Integer number) {
        if(number == 0) return 0;
        if(number == 1) return 1;

        Integer base = 0;
        Integer previous = 1;
        Integer current = 1;
        for (int i = 2; i <= number; i++) {
            current = previous+base;
            base = previous;
            previous = current;
        }
        return current;
    }

}
