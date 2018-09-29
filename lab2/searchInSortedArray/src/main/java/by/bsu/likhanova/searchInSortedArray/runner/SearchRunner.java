package by.bsu.likhanova.searchInSortedArray.runner;

import by.bsu.likhanova.searchInSortedArray.search.BinarySearch;
import by.bsu.likhanova.searchInSortedArray.search.InterpolationSearch;

public class SearchRunner {
    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29};
        long start = System.nanoTime();
        System.out.println(BinarySearch.runBinarySearch(array,23));
        long finish = System.nanoTime();
        System.out.println("Binary search with " + array.length + " elements: " + String.format("%,12d", (finish-start)) + " ns;");
        start = System.nanoTime();
        System.out.println(InterpolationSearch.runInterpolationSearch(array,23));
        finish = System.nanoTime();
        System.out.println("Interpolation search with " + array.length + " elements: " + String.format("%,12d", (finish-start)) + " ns;");
    }
}
