package com.techarha.training.ds;

import com.techarha.training.ds.list.DoubleLinkedListTest;
import com.techarha.training.ds.list.LinkedListTest;
import com.techarha.training.ds.list.List;
import com.techarha.training.ds.stack.StackTest;

public class TestExecutor {
    public static void main(String[] args) {
//        testLinkedList();
//        testDoubleLinkedList();
        testStack();
    }

    public static void testLinkedList() {
        LinkedListTest.sampleRun();
        LinkedListTest.printRecursive(LinkedListTest.getSampleList().getHead());
        List<String> list = LinkedListTest.getSampleList();
        LinkedListTest.reverseRecursiveTest(list);
        LinkedListTest.reverseRecursiveTest(list);
    }

    public static void testDoubleLinkedList() {
        List<String> list = DoubleLinkedListTest.getSampleList();
        System.out.println(list);

        DoubleLinkedListTest.sampleRun();
    }

    public static void testStack() {
//        StackTest.basicStringArrayTest();
        StackTest.basicGenericArrayTest();
    }
}
