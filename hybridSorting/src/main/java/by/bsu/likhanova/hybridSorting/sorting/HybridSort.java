package by.bsu.likhanova.hybridSorting.sorting;

import by.bsu.likhanova.hybridSorting.parameter.Parameters;

public class HybridSort {
    public static void hybridSort(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length > Parameters.TRANSITION_TO_INSERTION_SORT) {
            if (left < right) {
                int q = QuickSort.findQ(array, left, right);
                HybridSort.hybridSort(array, left, q);
                HybridSort.hybridSort(array, q + 1, right);
            }
        } else {
            InsertionSort.insertionSort(array, left, right);
        }
    }
}

