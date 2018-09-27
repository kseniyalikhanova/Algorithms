package by.bsu.likhanova.hybridSorting.sorting;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int q = findQ(array, left, right);
            quickSort(array, left, q);
            quickSort(array, q + 1, right);
        }
    }

    public static int findQ(int[] array, int left, int right) {
        int pivot = left + (right - left) / 2;
        int i = left;
        int j = right;
        while (i <= j) {
            while ((i < pivot) && (array[i] < array[pivot]))
                i++;
            while ((j > pivot) && (array[j] >= array[pivot]))
                j--;
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
                if (i == pivot)
                    pivot = j;
                else if (j == pivot)
                    pivot = i;
            }
        }
        return pivot;
    }
}

