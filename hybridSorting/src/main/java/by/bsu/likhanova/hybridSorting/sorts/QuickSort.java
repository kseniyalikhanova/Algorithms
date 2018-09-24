package by.bsu.likhanova.hybridSorting.sorts;

import by.bsu.likhanova.hybridSorting.printer.ArrayPrinter;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int q = findQ(array, left, right);
            if (left < q - 1)
                quickSort(array, left, q - 1);
            if (q < right)
                quickSort(array, q, right);
        }
    }

    private static int findQ(int[] array, int left, int right) {
        int pivot = left + (right - left) / 2;
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < array[pivot])
                i++;
            while (array[j] > array[pivot])
                j--;

            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}




