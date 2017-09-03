package com.techarha.training.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] sample = {9,8,7,6,5,4,3,2,1};
        bubbleSort(sample);
        for (int num: sample) {
            System.out.print(num+ " ");
        }
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastSorted = array.length - 1; //considering one pass of bubble sort, makes entry sorted.
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastSorted; i++) {
                if(array[i] > array[i+1]) {
                    isSorted = false;
                    swap(array, i, i+1);
                }
            }
            lastSorted--;
        }
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
