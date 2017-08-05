package com.techarha.training.ds;

import com.techarha.training.ds.linked_list.LinkedList;
import com.techarha.training.ds.linked_list.LinkedListTest;

public class TestExecutor {
    public static void main(String[] args) {
//        LinkedListTest.sampleRun();
//        LinkedListTest.printRecursive(LinkedListTest.getSampleList().getHead());
        LinkedList<String> list = LinkedListTest.getSampleList();
        LinkedListTest.reverseRecursiveTest(list);
        LinkedListTest.reverseRecursiveTest(list);

    }
}
