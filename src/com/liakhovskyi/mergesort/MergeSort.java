package com.liakhovskyi.mergesort;

public class MergeSort {

    private int[] array;

    public void sort(int[] inputArray) {
        this.array = inputArray;
        doSort(0, array.length - 1);
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
        int leftStart = lowerIndex;
        int rightStart = middle + 1;
        int k = lowerIndex;

        while (leftStart <= middle && rightStart <= higherIndex) {
            if (array[leftStart] <= array[rightStart]) {
                leftStart++;
            } else {
                int tempValue = array[rightStart];
                int index = rightStart;
                while (index != leftStart) {
                    array[index] = array[--index];
                }
                array[leftStart] = tempValue;
                leftStart++;
                middle++;
                rightStart++;
            }

        }
    }
}
