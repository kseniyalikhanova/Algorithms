package by.bsu.likhanova.searchInSortedArray.search;

public class BinarySearch {
    public static int runBinarySearch(int[] array, int key, int left, int right){
        int middle = left + (right-left)/2;
        if (right < left) {
            return -1;
        }
        if (key == array[middle]) {
            return middle;
        } else if (key < array[middle]) {
            return runBinarySearch(array, key, left, middle - 1);
        } else {
            return runBinarySearch(array, key, middle + 1, right);
        }
    }
}
