package com.techarha.training.ds.questions;


/**
 * Given two strings (a-z), how many characters do we need to remove (from either),
 * to make them anagrams.
 *
 * ex: hello, billion -> remove 6 characters to make them anagram (he from hello, biin from billion)
 */
public class Anagrams {

    private static final int ALPHABETS = 26;

    public static void main(String[] args) {
        System.out.println(calculateAnagram("as", "asdf"));
    }

    private static int calculateAnagram(String first, String second) {
        int[] firstCh = preProcess(first);
        int[] secondCh = preProcess(second);

        return calculateDelta(firstCh, secondCh);
    }

    private static int calculateDelta(int[] firstCh, int[] secondCh) {
        if(firstCh.length != secondCh.length) {
            return -1;
        }
        int delta=0;
        for(int i = 0; i < firstCh.length; i++) {
            delta += Math.abs(firstCh[i]-secondCh[i]);
        }
        return delta;
    }

    private static int[] preProcess(String first) {
        int[] characters = new int[ALPHABETS];
        int offset = (int) 'a';

        for(int i = 0; i<first.length(); i++) {
            int code = first.charAt(i) - offset;
            characters[code]++;
        }
        return characters;
    }


}
