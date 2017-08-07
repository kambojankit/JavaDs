package com.techarha.training.ds.tree;

public class TreeTest {
    public static void basicTest() {
        LinkedTree linkedTree = new LinkedTree();
        linkedTree.insert(5);
        linkedTree.insert(4);
        linkedTree.insert(2);
        linkedTree.insert(3);
        linkedTree.insert(8);
        linkedTree.insert(1);
        linkedTree.insert(9);
        linkedTree.insert(12);
        linkedTree.insert(14);

        System.out.println(linkedTree.getMin());
        System.out.println(linkedTree.getMax());
        System.out.println(linkedTree.getHeight());
    }
}
