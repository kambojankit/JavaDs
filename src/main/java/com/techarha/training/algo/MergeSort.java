package com.techarha.training.algo;

public class MergeSort {
    public static void main(String[] args) {
        int[] sample = {9,8,7,6,5,4,3,2,1};
        mergeSort(sample);
        for (int num: sample) {
            System.out.print(num+ " ");
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length -1);
    }

    private static void mergeSort(int[] array, int[] tempArray, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return;
        }

        int middle = (startIndex + endIndex) / 2;
        mergeSort(array, tempArray, startIndex, middle);
        mergeSort(array, tempArray, middle+1, endIndex);
        mergeHalves(array, tempArray, startIndex, endIndex);
    }

    private static void mergeHalves(int[] array, int[] tempArray, int startIndex, int endIndex) {
        int leftEnd = (startIndex + endIndex) / 2;
        int rightStart = leftEnd + 1;
        int size =  endIndex - startIndex + 1;

        int left = startIndex;
        int right = rightStart;
        int index = left;

        while(left <= leftEnd && right <= endIndex) {
            if(array[left] <= array[right]) {
                tempArray[index] = array[left];
                left++;
            }else {
                tempArray[index] = array[right];
                right++;
            }
            index++;
        }

        //copy over any remaining elements
        System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
        System.arraycopy(array, right, tempArray, index, endIndex - right + 1);
        System.arraycopy(tempArray, startIndex, array, startIndex, size);
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
