package com.techarha.training.ds.list;

public class DoubleLinkedListTest {
    public static List getSampleList() {
        List<String> list = new DoubleLinkedList<>();

        list.addToEnd("A");
        list.addToEnd("B");
        list.addToEnd("C");
        list.addToEnd("D");
        list.addToEnd("E");

        return list;
    }

    public static void sampleRun() {
        List<String> list = new DoubleLinkedList<String>();
        
        list.addToEnd("A");
        list.addToEnd("B");
        list.addToEnd("C");
        System.out.println(list.toString()); // list is A B C

        list.addToFront("D");
        System.out.println(list.toString()); // list is D A B C

        list.removeFromEnd();
        System.out.println(list.toString()); // C removed

        list.removeFromFront();
        System.out.println(list.toString()); // D removed

        list.removeFromFront();
        System.out.println(list.toString()); // A removed, list is B

    }
}
