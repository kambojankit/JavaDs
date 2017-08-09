package com.techarha.training.ds.tree;

import sun.misc.InnocuousThread;

/**
 * //TODO Write an implementation of a basic Binary tree using array
 */
public class BinaryArrayTree {
    Integer[] treeContainer;
    int ARRAY_SIZE= 10;

    private int getLeftChildIndex(int index) {
        return  2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return  2 * index + 2;
    }

    private Integer getLeftChild(int index) {
        return treeContainer[getLeftChildIndex(index)];
    }

    private Integer getRightChild(int index) {
        return treeContainer[getRightChildIndex(index)];
    }

    public BinaryArrayTree() {
        this.treeContainer = new Integer[ARRAY_SIZE];
    }

    public void Insert(Integer data) {

    }
}
