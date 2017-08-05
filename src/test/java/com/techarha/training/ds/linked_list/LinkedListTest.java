package com.techarha.training.ds.linked_list;

import com.techarha.training.ds.linked_list.LinkedList;
import com.techarha.training.ds.linked_list.Node;

public class LinkedListTest<T> {

    public static LinkedList getSampleList() {
        LinkedList<String> list = new LinkedList<String>();

        list.addToEnd("A");
        list.addToEnd("B");
        list.addToEnd("C");
        list.addToEnd("D");
        list.addToEnd("E");

        return list;
    }

    public static void sampleRun() {
        LinkedList<String> list = new LinkedList<String>();

        list.addToEnd("A");
        list.addToEnd("B");
        list.addToEnd("C");
        System.out.println(list.toString()); // list is A B C

        list.addToFront("D");
        System.out.println(list.toString()); // list is D A B C

        list.insertAt("E", 4);
        list.insertAt("F", 1);
        System.out.println(list.toString()); // list is D F A B C E

        list.removeAt(3);
        System.out.println(list.toString()); // B removed

        list.removeFromEnd();
        System.out.println(list.toString()); // E removed

        list.removeFromFront();
        System.out.println(list.toString()); // D removed

        list.insertAt("B", 2);
        list.removeFromFront();
        System.out.println(list.toString()); // F removed, list is A B C

        list.reverseList();
        System.out.println(list.toString()); // list is C B A

        list.reverseList();
        System.out.println(list.toString()); // list is A B C
    }

    public static void printRecursive(Node node) {
        if(node.getLink() == null) {
            System.out.print(node.getData()+ " ");
            return;
        }else {
            printRecursive(node.getLink());
            if(node.getData() != null ) System.out.print(node.getData()+ " ");
        }
    }

    public static void reverseRecursiveTest(LinkedList list) {
        list.reverseListRecursive(list.getHead());
        System.out.println(list.toString());
    }
}
