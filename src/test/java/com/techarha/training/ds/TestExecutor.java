package com.techarha.training.ds;

import com.techarha.training.ds.list.DoubleLinkedListTest;
import com.techarha.training.ds.list.LinkedListTest;
import com.techarha.training.ds.list.List;
import com.techarha.training.ds.queue.QueueTest;
import com.techarha.training.ds.stack.BalanceExpressionEnhanced;
import com.techarha.training.ds.tree.TreeTest;
import sun.awt.image.ImageWatched;

public class TestExecutor {
    public static void main(String[] args) {
//        testLinkedList();
//        testDoubleLinkedList();
//        testStack();
//        testQueue();
        testTree();
    }


    public static void testLinkedList() {
//        LinkedListTest.sampleRun();
//        LinkedListTest.printRecursive(LinkedListTest.getSampleList().getHead());
//        List<String> list = LinkedListTest.getSampleList();
//        LinkedListTest.reverseRecursiveTest(list);
//        LinkedListTest.reverseRecursiveTest(list);
        LinkedListTest.testCycleInLinkedList();
    }

    public static void testDoubleLinkedList() {
        List<String> list = DoubleLinkedListTest.getSampleList();
        System.out.println(list);

        DoubleLinkedListTest.sampleRun();
    }

    public static void testStack() {
//        StackTest.basicStringArrayTest();
//        StackTest.basicGenericArrayTest();
//        StackTest.basicGenericLinkedListStackTest();

//        LinkedList<String> list = LinkedListTest.getSampleLinkedList();
//        StackTest.reverseLinkedList(list);

        String testParen_1 = "()]"; // 1
        String testParen_2 = "<(}(><[})[]"; // 1
        String testParen_3 = "<(}(><[})[-=-=-==](){}<>"; // 4
        String testParen_4 = "{ () [ { < > } < }"; // 3
        String testParen_5 = "{ () [ { < > } < } > [] ()"; // 5
        String testParen_6 = "{ () [ { < > } ] }"; // 5
        String testParen_7 = "{()[{<>}]}"; // 5
//
//        int count_1 = StackTest.countBalancedParanthesis(testParen_1);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_1)+ ", total Count is: "+ count_1);
//
//        int count_2 = StackTest.countBalancedParanthesis(testParen_2);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_2)+ ", total Count is: "+ count_2);
//
//        int count_3 = StackTest.countBalancedParanthesis(testParen_3);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_3)+ ", total Count is: "+ count_3);
//
//        int count_4 = StackTest.countBalancedParanthesis(testParen_4);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_4)+ ", total Count is: "+ count_4);
//
//        int count_5 = StackTest.countBalancedParanthesis(testParen_5);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_5)+ ", total Count is: "+ count_5);
//
//        int count_6 = StackTest.countBalancedParanthesis(testParen_6);
//        System.out.println("Balanced?: " + StackTest.isBalancedParanthesis(testParen_6)+ ", total Count is: "+ count_6);

        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_1));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_2));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_3));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_4));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_5));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_6));
        System.out.println(BalanceExpressionEnhanced.isBalancedParenthesisEnhanced(testParen_7));


//        System.out.println("a+b is: " + StackTest.infixToPostfix("a+b"));
//        System.out.println("a+b is: " + StackTest.infixToPostfix("a+b-c"));
//        System.out.println("a+b is: " + StackTest.infixToPostfix("a+b*c"));
//        System.out.println("a+b is: " + StackTest.infixToPostfix("a+b/d"));
//        System.out.println("a+b is: " + StackTest.infixToPostfix("a+b*c-b/e"));
//        System.out.println("a+b is: " + StackTest.infixToPostfix("23*2"));

    }

    public static void testQueue() {
        QueueTest.basicArrayQueueTest();
        QueueTest.basicLinkedListQueueTest();
        QueueTest.basicCircularArrayQueueTest();
    }

    public static void testTree() {
//        TreeTest.basicTest();
//        TreeTest.basicArrayBinaryTreeTest();
        TreeTest.minHeapTest();
    }
}
