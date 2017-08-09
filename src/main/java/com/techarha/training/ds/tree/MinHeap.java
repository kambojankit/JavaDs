package com.techarha.training.ds.tree;

import java.util.Arrays;

/**
 * TODO Basic implementation of a Min Heap
 */
public class MinHeap {
    Integer[] treeContainer;
    int size = 0;
    int ARRAY_SIZE= 10;

    public MinHeap() {
        this.treeContainer = new Integer[ARRAY_SIZE];
    }

    public void insert(Integer data) {
        insert(0, data);
    }

    public Integer top() {
        return this.treeContainer[0];
    }

    //TODO Enhance implementation to dynamically increase array size if full
    private void insert(int rootIndex, Integer data) {
        if(rootIndex > ARRAY_SIZE || size == ARRAY_SIZE) {
            System.out.println("Resizing Array");
            this.ARRAY_SIZE = 2 * this.ARRAY_SIZE;
            this.treeContainer = Arrays.copyOf(this.treeContainer, ARRAY_SIZE);
        }
        treeContainer[size++] = data;
        heapifyUp(size-1);
    }


    private void heapifyUp(int index) {
        if(index <= 0) return;
        int parentIndex = getParentIndex(index);
        if(treeContainer[parentIndex] > treeContainer[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }else {
            return;
        }
    }

    private void swap(int leftIndex, int rightIndex) {
        Integer temp = this.treeContainer[leftIndex];
        this.treeContainer[leftIndex] = this.treeContainer[rightIndex];
        this.treeContainer[rightIndex] = temp;
    }

    private int getLeftChildIndex(int index) {
        return  2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return  2 * index + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1 ) / 2;
    }

    private Integer getLeftChild(int index) {
        return treeContainer[getLeftChildIndex(index)];
    }

    private Integer getRightChild(int index) {
        return treeContainer[getRightChildIndex(index)];
    }

    private Integer getParent(int index) {
        return treeContainer[getParentIndex(index)];
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
