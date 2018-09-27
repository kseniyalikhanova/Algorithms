package by.bsu.likhanova.hybridSorting.sorting;

public class InsertionSort {
    public static void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && (array[j] > curr)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }
}
