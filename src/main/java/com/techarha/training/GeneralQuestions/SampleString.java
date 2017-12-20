package com.techarha.training.GeneralQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 String Operations
 You are given a string
 S
 S.

 Q
 Q number of operations are performed on string
 S
 S.
 In each of these
 Q
 Q operations, you are given an index
 i
 n
 d
 ind and a character
 c
 h
 ch. For each operation, you have to update character at index
 i
 n
 d
 ind in string
 S
 S to
 c
 h
 ch, that is, after this operation
 S
 [
 i
 n
 d
 ]
 =
 c
 h
 S[ind]=ch.
 It is guaranteed that any index is updated atmost once.
 We call the final string after performing
 Q
 Q number of operations as
 s
 t
 r
 str.

 After this,
 M
 M number of operations are performed on string
 s
 t
 r
 str.
 In each of these
 M
 M operations, you are given two indices
 a
 a and
 b
 b. For each operation, you have to reverse the substring that lies between the indices
 a
 a and
 b
 b (inclusive).
 We call the final string after performing
 M
 M operations as
 f
 i
 n
 fin.

 Example: If string is "xyz" and
 one of the
 Q
 Q operations is
 1
 a
 1a, then string "xyz" now becomes "ayz" as
 S
 [
 1
 ]
 =
 a
 S[1]=a after the operation.
 one of the
 M
 M operations is
 1
 3
 13, then "ayz" now becomes "zya" as the substring lying between indices
 1
 1 and
 3
 3 is reversed.

 You have to print string
 s
 t
 r
 str, string
 f
 i
 n
 fin and the number of indices which have same characters at them in both strings
 s
 t
 r
 str and
 f
 i
 n
 fin.

 Input Format:
 First line consists of string
 S
 S.
 Next line consists of an integer denoting
 Q
 Q.
 Following
 Q
 Q lines contain two integers each:
 i
 n
 d
 ind and
 c
 h
 ch.
 Next line consists of an integer denoting
 M
 M.
 Following
 M
 M lines contain two integers each:
 a
 a and
 b
 b.

 Output Format:
 In first line, print string
 s
 t
 r
 str.
 In second line, print string
 f
 i
 n
 fin.
 In third line, print the number of indices which have same characters at them in both strings
 s
 t
 r
 str and
 f
 i
 n
 fin.

 Input Constraints:
 1
 ≤
 |
 S
 |
 ≤
 10
 2
 1≤|S|≤102;
 |
 S
 |
 |S| denotes length of string s.
 1
 ≤
 Q
 ≤
 |
 S
 |
 1≤Q≤|S|
 1
 ≤
 M
 ≤
 10
 3
 1≤M≤103
 1
 ≤
 i
 n
 d
 ≤
 |
 s
 |
 1≤ind≤|s|, all
 i
 n
 d
 ind values are unique.
 1
 ≤
 a
 ≤
 b
 ≤
 |
 s
 |
 1≤a≤b≤|s|
 c
 h
 ch will always be a lowercase English alphabet.
 String
 S
 S consists of lowercase English alphabets only.
 All indices are 1 based.

 Sample Input
 helloworld
 2
 1 a
 8 x
 2
 2 3
 2 4
 Sample Output
 aellowoxld
 alelowoxld
 8
 Explanation
 Performing first Q (=2) operations: In first operation, S[1] = 'a', so string becomes "aelloworld"
 In first operation, S[8] = 'x', so string becomes "aellowoxld"

 After performing Q operations, the string becomes "aellowoxld".

 We have to perform M(=2) operations on the string "aellowoxld".
 In first operation, we have to reverse the string lying between indices 2 and 3, so the string now becomes "alelowoxld". ("el" now becomes "le")
 Similarly in second operation, we reverse the string lying between indices 2 and 4, so the string becomes "alelowoxld". ("lel" on reversing remains the same)

 String str= "aellowoxld"
 String fin= "alelowoxld"
 No of characters same in both of them = 8.

 Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 Time Limit: 1.0 sec(s) for each input file
 Memory Limit: 256 MB
 Source Limit: 1024 KB
 Marking Scheme: Marks are awarded if any testcase passes
 Allowed Languages: Java, Java 8

 */
public class SampleString {

    /*public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        //Read input string from STDIN
        String providedInput = name;

        //Read Q value from STDIN
        Integer repOperationCount = Integer.parseInt(br.readLine());

        //Holding values to replace
        Map<Integer, Character> repOperationsData = new HashMap<>();
        int counter = 0;
        while(counter < repOperationCount) {
            String input = br.readLine();
            String[] data = input.split(" ");

            repOperationsData.put(Integer.parseInt(data[0]), data[1].charAt(0));
            counter++;
        }

        //Read M value from STDIN
        Integer reverseOperationCount = Integer.parseInt(br.readLine());
        ArrayList<String> reverseOperationsData = new ArrayList<>();

        counter = 0;
        while(counter < reverseOperationCount) {
            reverseOperationsData.add(br.readLine());
            counter++;
        }

        String replaced = performReplaceOperations(providedInput, repOperationsData);
        System.out.println(replaced);

        String reversed = performReverseOperations(replaced, reverseOperationsData);
        System.out.println(reversed);

        System.out.println(findCommonDataIndices(replaced, reversed));
    }

    private static int findCommonDataIndices(String replaced, String reversed) {
        int count = 0;
        for(int i = 0; i < replaced.length(); i++) {
            if(replaced.charAt(i) == reversed.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static String performReplaceOperations(String input, Map<Integer, Character> repOperationsData) {
        char[] inputCharArr = input.toCharArray();

        for(Map.Entry<Integer, Character> entry : repOperationsData.entrySet()) {
            inputCharArr[entry.getKey() - 1] = entry.getValue();
        }

        return String.valueOf(inputCharArr);
    }

    private static String performReverseOperations(String input, ArrayList<String> reverseOperationsData) {
        char[] inputCharArr = input.toCharArray();

        for(String entry : reverseOperationsData) {
            String[] data = entry.split(" ");
            int startInd = Integer.parseInt(data[0]) - 1 ;
            int endInd = Integer.parseInt(data[1]) - 1;

            for(int i = startInd, e = endInd; i < e ;i++, e--){
                char temp = inputCharArr[e];
                inputCharArr[e] = inputCharArr[i];
                inputCharArr[i] = temp;
            }
        }

        return String.valueOf(inputCharArr);
    }*/
}