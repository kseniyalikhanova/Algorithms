package by.bsu.likhanova.searchInSortedArray.search;

public class BinarySearch {
    public static int runBinarySearch(int[] array, int key) {
        int index = -1;
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (key == array[middle]) {
                index = middle;
                break;
            } else if (key < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (key == array[left]) {
            index = left;
        } else if (key == array[right]) {
            index = right;
        }
        return index;
    }
}
