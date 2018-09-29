package by.bsu.likhanova.searchInSortedArray.search;

public class BinarySearch {
    public static int runBinarySearch(int[] array, int key){
        int index = -1;
        int left = 0, right = array.length, mid;
        while (left < right) {
            mid = left + (right-left)/2;
            if (key == array[mid]) {
                index = mid;
                break;
            } else {
                if (key <= array[mid]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return index;
    }
}
