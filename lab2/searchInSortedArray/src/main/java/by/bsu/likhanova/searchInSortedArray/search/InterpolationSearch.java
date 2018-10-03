package by.bsu.likhanova.searchInSortedArray.search;

import java.util.ArrayList;

public class InterpolationSearch {
    public static int runInterpolationSearch(ArrayList<Integer> array, int key) {
        int index = -1;
        int left = 0;
        int right = array.size() - 1;
        int middle;
        while (array.get(left) < key && array.get(right) > key) {
            middle = left + ((key - array.get(left)) * (right - left)) / (array.get(right) - array.get(left));
            if (key == array.get(middle)) {
                index = middle;
                break;
            } else if (key > array.get(middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (array.get(left) == key) {
            index = left;
        } else if (array.get(right) == key) {
            index = right;
        }
        return index;
    }
}
