package by.bsu.likhanova.hybridSorting.sorts;

import by.bsu.likhanova.hybridSorting.parameter.Parameters;

public class HybridSort {
    public static void hybridSort(int[] array, int left, int right) {
        if ((right - left) > Parameters.TRANSITION_TO_INSERTION_SORT) {
            if (left < right) {
                int q = QuickSort.findQ(array, left, right);
                HybridSort.hybridSort(array, left, q - 1);
                HybridSort.hybridSort(array, q, right);
            }
        } else {
            InsertionSort.insertionSort(array);
        }
    }
}
