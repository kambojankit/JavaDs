package com.techarha.training.ds.tree;

import sun.misc.InnocuousThread;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * //TODO For the given implementation of a basic Binary tree using array, Add other tree operations
 * //TODO like, DFS (Preorder, Inorder, Postorder), BFS, delete node
 */
public class ArrayBinarySearchTree {
    Integer[] treeContainer;
    int size;
    int ARRAY_SIZE= 10;

    public ArrayBinarySearchTree() {
        this.treeContainer = new Integer[ARRAY_SIZE];
    }

    public void insert(Integer data) {
        insert(0, data);
    }


    //TODO Enhance implementation to dynamically increase array size if full
    private void insert(int rootIndex, Integer data) {
        if(rootIndex > ARRAY_SIZE || size == ARRAY_SIZE) {
            System.out.println("Resizing Array");
            this.ARRAY_SIZE = 2* this.ARRAY_SIZE;
            this.treeContainer = Arrays.copyOf(this.treeContainer, ARRAY_SIZE);
        }
        if(treeContainer[rootIndex] == null) {
            size++;
            treeContainer[rootIndex] = data;
            return;
        }
        if(data <= treeContainer[rootIndex] ) {
            insert(getLeftChildIndex(rootIndex), data);
        }else {
            insert(getRightChildIndex(rootIndex), data);
        }
    }

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

    @Override
    public String toString() {
        String buff = "";
        int i=0;
        for (Integer value : this.treeContainer) {
            if(value != null) {
                buff += value;
                if(i<= size) {
                    buff += ", ";
                    i++;
                }
            }
        }
        return buff;
    }
}
