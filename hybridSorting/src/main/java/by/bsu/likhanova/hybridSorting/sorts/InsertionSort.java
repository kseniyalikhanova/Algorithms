package by.bsu.likhanova.hybridSorting.sorts;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
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
