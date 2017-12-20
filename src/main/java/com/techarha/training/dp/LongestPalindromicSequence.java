package com.techarha.training.dp;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a String, find out the largest Palindrome subsequence (print sequence and its length both) in the string if any.
 * Some examples:
 *      "character"         -->     carac
 *      "underqualified     -->     deified
 *      "turboventilator"   -->     rotator
 */
public class LongestPalindromicSequence {

    public static void main(String[] args) {
        String input = "turboventilator";
//        System.out.print(printLongestSequence(input, 0, input.length() - 1));
//        String largestSubstring = printLongestSequenceString(input, 0, input.length() - 1);
//        System.out.print("The largest Palindrome substring is: \"" + largestSubstring + "\" with length: " + largestSubstring.length());

        Map<String, String> memo = new HashMap<>();
        String largestSubstring = printLongestSequenceStringMemo(input, memo, 0, input.length() - 1);

        System.out.print("The largest Palindrome substring is: \"" + largestSubstring + "\" with length: " + largestSubstring.length());
    }

    // basic initial solution to find only length of the largest substring.
    private static int printLongestSequence(String input, int start, int end) {
        //check boundry conditions
        if(start >= input.length() || end >= input.length() || start < 0 || end < 0) {
            return 0;
        }

        if(start == end) {
            return 1;
        }
        if(input.charAt(start) == input.charAt(end)) {
            if(start + 1 == end) {
                return 2;
            }else {
                return 2 + printLongestSequence(input, start + 1, end - 1);
            }
        }else {
            return Integer.max(
                    printLongestSequence(input, start + 1, end),
                    printLongestSequence(input, start, end -1));
        }
    }

    /**
     * The upgraded solution to find the actual subsequence instead of just the length.
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static String printLongestSequenceString(String input, int start, int end) {
        //check boundry conditions
        if(start >= input.length() || end >= input.length() || start < 0 || end < 0) {
            return "";
        }

        if(start == end) {
            return input.charAt(start)+"";
        }
        if(input.charAt(start) == input.charAt(end)) {
            if(start + 1 == end) {
                return input.charAt(start) + "";
            }else {
                return input.charAt(start) + printLongestSequenceString(input, start + 1, end - 1) + input.charAt(end);
            }
        }else {
            String first =  printLongestSequenceString(input, start + 1, end);
            String second =  printLongestSequenceString(input, start, end -1);

            return first.length() - second.length() >= 0 ? first : second;
        }
    }

    /**
     * The upgraded Memoised solution to find the actual subsequence instead of just the length.
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static String printLongestSequenceStringMemo(String input, Map<String, String> memo, int start, int end) {
        //check boundry conditions
        if(start >= input.length() || end >= input.length() || start < 0 || end < 0) {
            return "";
        }

        if(memo.containsKey(start + "-" + end)) {
            return memo.get(start + "-" + end);
        }

        if(start == end) {
            memo.put(start + "-" + end, input.charAt(start) + "");
            return memo.get(start + "-" + end);
        }
        if(input.charAt(start) == input.charAt(end)) {
            if(start + 1 == end) {
                memo.put(start + "-" + end, input.charAt(start) + "");
                return memo.get(start + "-" + end);
            }else {
                String seq = input.charAt(start) + printLongestSequenceString(input, start + 1, end - 1) + input.charAt(end);
                memo.put(start + "-" + end, seq);
                return memo.get(start + "-" + end);
            }
        }else {
            String first =  printLongestSequenceString(input, start + 1, end);
            String second =  printLongestSequenceString(input, start, end -1);

            String result = first.length() - second.length() >= 0 ? first : second;
            memo.put(start + "-" + end, result);
            return memo.get(start + "-" + end);
        }
    }

}
