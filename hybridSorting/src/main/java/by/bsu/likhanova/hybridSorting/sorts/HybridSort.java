package by.bsu.likhanova.hybridSorting.sorts;

import by.bsu.likhanova.hybridSorting.parameter.Parameters;

public class HybridSort {
    public static void hybridSort(int[] array, int left, int right) {
        if (left < right) {
            int q = QuickSort.findQ(array, left, right);
            if ((right - left) > Parameters.TRANSITION_TO_INSERTION_SORT) {
                QuickSort.quickSort(array, left, q - 1);
                QuickSort.quickSort(array, q, right);
            } else {
                InsertionSort.InsertionSort(array);
            }
        }
    }
}
