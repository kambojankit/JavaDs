package com.techarha.training.ds.tree;

public class TreeTest {
    public static void basicTest() {
        BinaryLinkedTree binaryLinkedTree = new BinaryLinkedTree();
        binaryLinkedTree.insert(5);
        binaryLinkedTree.insert(4);
        binaryLinkedTree.insert(2);
        binaryLinkedTree.insert(3);
        binaryLinkedTree.insert(8);
        binaryLinkedTree.insert(11);
        binaryLinkedTree.insert(1);
        binaryLinkedTree.insert(9);
        binaryLinkedTree.insert(12);
        binaryLinkedTree.insert(14);
        binaryLinkedTree.insert(6);
        binaryLinkedTree.insert(10);
        binaryLinkedTree.insert(13);
        binaryLinkedTree.insert(7);

        System.out.println(binaryLinkedTree.getMin());
        System.out.println(binaryLinkedTree.getMax());
        System.out.println(binaryLinkedTree.getHeight());

        binaryLinkedTree.traversePreOrderRec();
        System.out.println();
        binaryLinkedTree.traverseInOrderRec();
        System.out.println();
        binaryLinkedTree.traversePostOrderRec();
        System.out.println();

        System.out.println("Is BST? "+ TreeUtils.isBst(binaryLinkedTree));
        binaryLinkedTree.breadthFirstTraversal();
        System.out.println();
        System.out.println("=====================> Pre Deletion");
        binaryLinkedTree.traverseInOrderRec();
        System.out.println();
        BinaryLinkedTree newTree = binaryLinkedTree.deleteNodeIntoTree(8);
        System.out.println("=====================> Post Deletion");
        newTree.traverseInOrderRec();
        System.out.println();
        binaryLinkedTree.traverseInOrderRec();
    }
    public static void basicArrayBinaryTreeTest() {
        ArrayBinarySearchTree arrayTree = new ArrayBinarySearchTree();

        arrayTree.insert(5);
        arrayTree.insert(3);
        arrayTree.insert(1);
        arrayTree.insert(4);
        arrayTree.insert(7);
        arrayTree.insert(6);
        arrayTree.insert(8);
        arrayTree.insert(0);
        arrayTree.insert(9);
        arrayTree.insert(10);
        arrayTree.insert(2);
        arrayTree.insert(12);
        arrayTree.insert(11);
        arrayTree.insert(13);


        System.out.println(arrayTree);
    }

    public static void minHeapTest() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(43);
        minHeap.insert(22);
        minHeap.insert(42);
        minHeap.insert(56);
        minHeap.insert(7);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(1);

        System.out.println(minHeap);
    }
}
