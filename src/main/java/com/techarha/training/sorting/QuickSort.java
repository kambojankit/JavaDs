package com.techarha.training.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] sample = {9,8,7,6,5,4,3,2,1};
        quicksort(sample);
        for (int num: sample) {
            System.out.print(num+ " ");
        }
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];

        int index = partition(array, left, right, pivot);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while ( left <= right ) {
            while (array[left] < pivot ) {
                left++;
            }

            while (array[right] > pivot ) {
                right--;
            }

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
