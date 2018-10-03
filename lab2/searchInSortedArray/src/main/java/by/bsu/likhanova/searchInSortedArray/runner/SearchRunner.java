package by.bsu.likhanova.searchInSortedArray.runner;

import by.bsu.likhanova.searchInSortedArray.action.RandomNumbers;
import by.bsu.likhanova.searchInSortedArray.printer.ArrayPrinter;
import by.bsu.likhanova.searchInSortedArray.search.BinarySearch;
import by.bsu.likhanova.searchInSortedArray.search.InterpolationSearch;

import java.util.ArrayList;
import java.util.Collections;

public class SearchRunner {
    public static void main(String[] args) {
        ArrayList<Integer> array = RandomNumbers.generateRandomArray(12, 0, 200);
        Collections.sort(array);
        System.out.println(array);
        int key = RandomNumbers.generateRandomNumber(0,array.size()-1);
        key = array.get(key);
        System.out.println("Element for search: " + key);
        long start = 0;
        long finish = 0;
        start = System.nanoTime();
        System.out.println(BinarySearch.runBinarySearch(array,key));
         finish = System.nanoTime();
        System.out.println("Binary search with " + array.size() + " elements: " + String.format("%,12d", (finish-start)) + " ns;");
        start = System.nanoTime();
        System.out.println(InterpolationSearch.runInterpolationSearch(array,key));
        finish = System.nanoTime();
        System.out.println("Interpolation search with " + array.size() + " elements: " + String.format("%,12d", (finish-start)) + " ns;");
    }
}
