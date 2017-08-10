package com.techarha.training.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executor {
    private static final String THREE = "Fizz";
    private static final String FIVE = "Buzz";

    public static void main(String[] args) throws IOException {

//        /*
//         * Read input from stdin and provide input before running
//         * Use either of these methods for input
//        */
//
//        // BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//
//        String line2 = br.readLine();
//
//        String[] values = line2.split(" ");
//
//
//        for (String val: values) {
//            int j = Integer.parseInt(val);
//            for (int i = 1; i < j+1; i++) {
//                if ( i % 3 == 0 && i % 5 == 0) {
//                    System.out.println(THREE + FIVE);
//                    continue;
//                }
//
//                if (i % 3 == 0) {
//                    System.out.println(THREE);
//                    continue;
//                }
//
//                if (i % 5 == 0) {
//                    System.out.println(FIVE);
//                    continue;
//                }
//                System.out.println(i);
//            }
//        }

        char[] ALPHABETS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String startWord = br.readLine();
            String endWord = br.readLine();

            String line = br.readLine();
            int N = Integer.parseInt(line);


            List<String> dictionary = new ArrayList<String>();
            for (int i = 0; i < N; i++) {
                dictionary.add(br.readLine());
            }

            int startLength = startWord.trim().length();
            int endLength = endWord.trim().length();

            if(startLength != endLength) {
                System.out.println(0);
                return;
            }

            char[] startArr = startWord.toCharArray();
            char[] endArr = endWord.toCharArray();

            int min = 0;
            for(int i =0; i< startLength ; i++) {

            }
    }

//    private findMinIndex() {
//
//    }
}
