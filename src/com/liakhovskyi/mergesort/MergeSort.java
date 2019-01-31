package com.liakhovskyi.mergesort;

import java.util.Arrays;

public class MergeSort {

    private int[] array;
    private int[] tempArray;
    private int length;

    public void sort(int[] inputArray) {
        this.array = inputArray;
        this.length = inputArray.length;
        doSort(0, length - 1);
    }

    private void doSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doSort(lowerIndex, middle);
            doSort(middle + 1, higherIndex);
            merge(lowerIndex, middle, higherIndex);
        }
    }

    private void merge(int lowerIndex, int middle, int higherIndex) {
        tempArray = Arrays.copyOf(array,length);

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
