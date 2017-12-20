package com.techarha.training.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] sample = {9,8,7,6,5,4,3,2,1};

        System.out.print("Initial Array: ");
        printArray(sample, 1);

        System.out.println("");
        insertionSort(sample);

        System.out.print("Sorted Array: ");
        printArray(sample, 1);
    }

    public static void insertionSort(int[] array) {
        if(array == null && array.length <= 1) {
            return;
        }
        int position = 1;
        for(int key = position; key < array.length; key++) {
            if(array[key] > array[key - 1]) {
                continue;
            }else {
                insertKey(array, key);
            }
//            printArray(array, 2);
        }
    }


    private static void insertKey(int[] array, int currentKeyPosition) {
        int prevPosition = currentKeyPosition - 1;

        while(prevPosition  >= 0 && array[currentKeyPosition] < array[prevPosition]) {
            swap(array, prevPosition, currentKeyPosition);
            currentKeyPosition--;
            prevPosition--;

//            printArray(array, 3);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static void printArray(int[] array, int identationCount) {
        String prefix = "";
        switch (identationCount) {
            case 1:
                prefix = "";
                break;
            case 2:
                prefix = "  --> ";
                break;
            case 3:
                prefix = "       :: ";
                break;
        }

        System.out.print(prefix);
        int length = 1;
        for (int num: array) {
            System.out.print(num);
            if(length < array.length) System.out.print(",");
            length++;
        }
        System.out.println("");
    }
}
