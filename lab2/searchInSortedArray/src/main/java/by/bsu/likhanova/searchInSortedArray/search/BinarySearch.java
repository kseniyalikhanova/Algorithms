package by.bsu.likhanova.searchInSortedArray.search;

import java.util.ArrayList;

public class BinarySearch {

    public static int runBinarySearch(ArrayList<Integer> array, int key) {
        int index = -1;
        int left = 0;
        int right = array.size() - 1;
        int middle;
        while (array.get(left) < key && array.get(right) > key) {
            middle = left + (right - left) / 2;
            if (key == array.get(middle)) {
                index = middle;
                break;
            } else if (key < array.get(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (key == array.get(left)) {
            index = left;
        } else if (key == array.get(right)){
            index = right;
        }
        return index;
    }
}
