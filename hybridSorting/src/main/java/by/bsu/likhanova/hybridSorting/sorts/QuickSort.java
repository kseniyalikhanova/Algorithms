package by.bsu.likhanova.hybridSorting.sorts;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int q = findQ(array, left, right);
            quickSort(array, left, q - 1);
            quickSort(array, q, right);
        }
    }

    public static int findQ(int[] array, int left, int right) {
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
