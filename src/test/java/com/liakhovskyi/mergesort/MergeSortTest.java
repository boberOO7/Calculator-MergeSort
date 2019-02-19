package com.liakhovskyi.mergesort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MergeSortTest {

    @Test
    public void testArraySorting() {
        MergeSort mergeSort = new MergeSort();

        int[] expectedResult = {1, 2, 6, 9, 10, 15, 16, 17, 20};
        int[] actualResult = {6, 10, 16, 9, 1, 15, 20, 17, 2};

        mergeSort.sort(actualResult);

        assertArrayEquals(expectedResult, actualResult);
    }
}