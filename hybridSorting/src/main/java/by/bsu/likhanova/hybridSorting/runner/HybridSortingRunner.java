package by.bsu.likhanova.hybridSorting.runner;

import by.bsu.likhanova.hybridSorting.creator.FromFileArrayCreator;
import by.bsu.likhanova.hybridSorting.parameter.Parameters;
import by.bsu.likhanova.hybridSorting.sorting.HybridSort;
import by.bsu.likhanova.hybridSorting.sorting.QuickSort;

import java.io.IOException;
import java.util.ArrayList;

public class HybridSortingRunner {
    public static void main(String[] args) throws IOException {

//        for (int i = 1; i <= Parameters.FILE_AMOUNT; i++) {
//            String fileName = Parameters.FILE_NAME + i + Parameters.FILE_EXPANSION;
//            WriterInFile.writeArrayInFile(fileName);
//            System.out.println("successfully");
//        }

        ArrayList<int[]> arrayWithNumberArrays = FromFileArrayCreator.initArrays();
        long start = System.nanoTime();
        for (int[] array : arrayWithNumberArrays) {
            QuickSort.quickSort(array, 0, Parameters.ARRAY_LENGTH - 1);
        }
        long finish = System.nanoTime();
        long result = (finish - start) / Parameters.FILE_AMOUNT;
        System.out.println("Average time of performance of QuickSort = " + String.format("%,12d", result) + " ns");

        arrayWithNumberArrays = FromFileArrayCreator.initArrays();
        start = System.nanoTime();
        for (int[] array : arrayWithNumberArrays) {
            HybridSort.hybridSort(array, 0, Parameters.ARRAY_LENGTH - 1);
        }
        finish = System.nanoTime();
        result = (finish - start) / Parameters.FILE_AMOUNT;
        System.out.println("Average time of performance of HybridSort = " + String.format("%,12d", result) + " ns");
        System.out.println("When TRANSITION_TO_INSERTION_SORT = " + Parameters.TRANSITION_TO_INSERTION_SORT + ";");
    }
}
