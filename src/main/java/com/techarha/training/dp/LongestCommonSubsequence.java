package com.techarha.training.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given
 *
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("In the second episode we coded ",
//                "An elegant recursive approach to solving", 0, 0));
//        System.out.println(longestCommonSubsequence("ABGSD", "GABDJI", 0, 0));

        Map<String, String> memo = new HashMap<>();
//        System.out.println(longestCommonSubsequenceMemo("ABGSD", "GABDJI", 0, 0, memo));
        System.out.println(longestCommonSubsequenceMemo("In the second episode we coded ",
                "An elegant recursive approach to solving", 0, 0, memo));
        System.out.println(lcsBottomUp("In the second episode we coded ",
                "An elegant recursive approach to solving"));
//        System.out.println(lcsBottomUp("ABGSD", "GABDJI"));
    }

    // basic solution
    private static String longestCommonSubsequence(String first, String second, int firstIndex, int secondIndex) {
        if(first == null
                || first.isEmpty()
                || second == first
                || second.isEmpty()
                || firstIndex >= first.length()
                || secondIndex >= second.length()) {
            return "";
        }

        if(first.charAt(firstIndex) == second.charAt(secondIndex)) {
            return first.charAt(firstIndex) +
                    longestCommonSubsequence(first, second, firstIndex + 1, secondIndex + 1);
        }else {
            String firstRes = longestCommonSubsequence(first, second, firstIndex + 1, secondIndex);
            String secondRes = longestCommonSubsequence(first, second, firstIndex, secondIndex + 1);

            return (secondRes.length() - firstRes.length() ) >= 0 ? secondRes : firstRes;
        }
    }

    // Enhanced Recursive Memoize Algo
    private static String longestCommonSubsequenceMemo(String first, String second, int firstIndex, int secondIndex, Map<String, String> memo) {
        if(first == null
                || first.isEmpty()
                || second == first
                || second.isEmpty()
                || firstIndex >= first.length()
                || secondIndex >= second.length()) {
            return "";
        }

        if(memo.containsKey(firstIndex + "-" + secondIndex)) {
            return memo.get(firstIndex + "-" + secondIndex);
        }

        if(first.charAt(firstIndex) == second.charAt(secondIndex)) {

            String result = first.charAt(firstIndex) +
                    longestCommonSubsequenceMemo(first, second, firstIndex + 1, secondIndex + 1, memo);

            memo.put(firstIndex + "-" + secondIndex, result);

        }else {

            String firstRes = longestCommonSubsequenceMemo(first, second, firstIndex + 1, secondIndex, memo);
            String secondRes = longestCommonSubsequenceMemo(first, second, firstIndex, secondIndex + 1, memo);

            String result = (secondRes.length() - firstRes.length() ) >= 0 ? secondRes : firstRes;

            memo.put(firstIndex + "-" + secondIndex, result);

        }
        return memo.get(firstIndex + "-" + secondIndex);
    }

    private static String lcsBottomUp(String first, String second) {
        if(first == null
            || first.isEmpty()
            || second == first
            || second.isEmpty()) {
            return "";
        }

        char[] firstCharArr = first.toCharArray();
        char[] secondCharArr = second.toCharArray();

        int rows = first.length();
        int columns = second.length();

        int[][] table = new int[rows+1][columns+1];

        prepareAndFillTable(firstCharArr, secondCharArr, rows, columns, table);


        return findLCS(firstCharArr, secondCharArr, rows, columns, table);
    }

    private static void prepareAndFillTable(char[] firstCharArr, char[] secondCharArr, int rows, int columns, int[][] table) {
        int r = 0;
        while(r <= rows) {
            table[r][0] = 0;
            r++;
        }

        int c = 0;
        while(c <= columns) {
            table[0][c] = 0;
            c++;
        }

        for(int row = 1; row <= rows; row++) {
            for (int col = 1; col <= columns; col ++) {
                if(firstCharArr[row-1] == secondCharArr[col-1]) {
                    table[row][col] = table[row-1][col-1] + 1;
                } else {
                    table[row][col] = Integer.max(table[row-1][col], table[row][col-1] );
                }
            }
        }
    }

    private static String findLCS(char[] firstCharArr, char[] secondCharArr, int rows, int columns, int[][] table) {
        String result = "";
        int row = rows;
        int col = columns;

        while(table[row][col] != 0 && (row > 0 || col > 0)) {
            if(firstCharArr[row-1] == secondCharArr[col-1]) {
                result = firstCharArr[row-1] + result;

                row = row - 1;
                col = col - 1;
            }else {
                if(table[row-1][col] == table[row][col]) {
                    row = row - 1;
                } else {
                    col = col - 1;
                }
            }
        }

        return result;
    }
}
