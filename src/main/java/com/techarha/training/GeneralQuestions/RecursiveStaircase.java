package com.techarha.training.GeneralQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1, 2 or 3 stairs at a time.
 * Count the number of ways, the person can reach the top.
 *
 */
public class RecursiveStaircase {

    //Simple naive recursive approach
    private static int countPathsR(int steps) {
        if(steps < 0) return 0;
        if(steps == 0) return 1;
        if(steps == 1) return 1;
        if(steps == 2) return 2;
        return countPathsR(steps - 1) + countPathsR(steps - 2) + countPathsR(steps - 3);
    }

    public static int countPaths(int steps) {
        int[] memo = new int[steps+1];
        Arrays.fill(memo, -1);

        int count = countPathsMemo(steps, memo);
        return count;
    }

    //Memoize solution
    private static int countPathsMemo(int steps, int[] memo) {
        if(steps < 0) {
            System.out.println("Calculating value: "+ steps);
            return 0;
        }
        if(steps == 0) {
            System.out.println("Calculating value: "+ steps);
            memo[0] = 1;
            return 1;
        }
        if(steps == 1) {
            System.out.println("Calculating value: "+ steps);
            memo[1] = 1;
            return 1;
        }
        if(steps == 2) {
            System.out.println("Calculating value: "+ steps);
            memo[2] = 2;
            return 2;
        }

        if(memo[steps] == -1) {
            System.out.println("Calculating value: "+ steps);
            memo[steps] = countPathsMemo(steps - 1, memo) + countPathsMemo(steps - 2, memo) + countPathsMemo(steps - 3, memo);
        }

        return memo[steps];
    }

    public static void main(String[] args) {

        System.out.println("" + countPaths(10));
    }
}
