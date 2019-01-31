package com.liakhovskyi.mergesort;

public class Main {
    public static void main(String[] args) {
        int[] inputArray = {1, 6, 3, 4, 15, 10, 9, 7};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArray);

        System.out.print("[");

        for (int element : inputArray) {
            System.out.print(element + "\t");
        }
        System.out.print("\b]");
    }
}
