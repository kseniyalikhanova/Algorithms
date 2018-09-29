package by.bsu.likhanova.searchInSortedArray.search;

public class InterpolationSearch {
    public static int runInterpolationSearch(int[] array, int key) {
        int index = -1;
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (array[left] < key && array[right] > key) {
            middle = left + ((key - array[left]) * (right - left)) / (array[right] - array[left]);
            if (key == array[middle]) {
                index = middle;
                break;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (array[left] == key) {
            index = left;
        } else if (array[right] == key) {
            index = right;
        }
        return index;
    }
}
