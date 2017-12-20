package com.techarha.training.GeneralQuestions;

import com.techarha.training.ds.list.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**
 School Prayer
 You are given the task to manage students coming to morning prayer in the school. Students having roll numbers 1 to N are coming in an arbitrary manner and you need to make them stand in a queue such that queue is always in ascending order of roll number.

 In order to achieve this task, for every incoming student you need to find a student in the queue he will be standing behind (or in front of the queue if no such student is present in the queue ).

 For example, if currently, the queue is 1 2 4 and student with roll number 3 arrives, you will have to locate 2 and make 3 stand behind 2.
 For each incoming student, find the roll number of student he will be standing behind ( -1 in case no student with roll less than current exists).

 Input Format:
 The first line of input will contain T number of test cases.
 The first line of each test case will contain N, the number of students.
 The second line of each test case will have N distinct space separated numbers denoting the order in which each student is coming.

 Output Format:
 Output a single number which is the sum of N numbers where ith number denotes answer for ith incoming student.
 Answer for each test case should come in a new line.

 Input Constraints:
 1≤T≤10

 1≤N≤105
 1≤RollNumber≤N

 Sample Input
2
4
2 1 4 3
6
4 6 1 2 3 5

 Sample Output
 2
 9

 Explanation
 For the first case
 1. Current queue {} , 2 will stand at front so -1.
 2. Current queue {2}, 1 will stand at front so -1.
 3. Current queue {1,2} 4 will stand behind 2 so 2.
 4. Current queue {1,2,4} 3 will stand behind 3 so 2.
 so sum is -1 -1 + 2 + 2 = 2

 Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.


 */
public class StudentQueue {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer testCaseCount = Integer.parseInt(br.readLine());

        int[][] testCases = new int[testCaseCount][];

        for(int i = 0; i< testCaseCount; i++) {
            int count = Integer.parseInt(br.readLine());
            testCases[i] = new int[count];

            String[] data = br.readLine().split(" ");
            while(count > 0) {
                testCases[i][count-1] = Integer.parseInt(data[count-1]);
                count--;
            }
        }

        for(int i = 0; i < testCases.length; i++) {
            System.out.println(findPositionSum(testCases[i]));
        }
    }

    private static int findPositionSum(int[] testCase) {
        int totalValue = 0;

        int[] queue = new int[testCase.length];

        ArrayList<Integer> list = new ArrayList<>();        
        int queueLength = -1;

        for(int i = 0; i < testCase.length; i++) {
            int current = testCase[i];

            int insertInd = 0;
            if(queueLength != -1) {
                insertInd = findInsertIndex(queue, 0, queueLength, current);
            }
            insertQueue(queue, insertInd, testCase[i]);
            queueLength++;
            if(insertInd <= 0) {
                totalValue += -1;
            }else {
                totalValue += queue[insertInd-1];
            }

        }

        //find value at position - 1, and add to total
        return totalValue;
    }

    private static void insertQueue(int[] queue, int index, int value) {
        int counter = queue.length - 1;
        while( counter > index) {
            queue[counter] = queue[counter - 1];
            counter--;
        }
        queue[index] = value;

    }

    private static int findInsertIndex(int[] queue, int start, int end, int value){

        if(start > end || end < 0) {
            return start;
        }

        int mid = (start + end) / 2;
        if(queue[mid] == value) {
            return mid;
        }else if(queue[mid] > value) {
            return findInsertIndex(queue, start, mid - 1, value);
        }else {
            return findInsertIndex(queue, mid + 1, end, value);
        }
    }
}
