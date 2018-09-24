package by.bsu.likhanova.hybridSorting.runner;

import by.bsu.likhanova.hybridSorting.creator.FromFileArrayCreator;
import by.bsu.likhanova.hybridSorting.parameter.Parameters;
import by.bsu.likhanova.hybridSorting.printer.ArrayPrinter;
import by.bsu.likhanova.hybridSorting.sorts.QuickSort;

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
        ArrayPrinter.printArray(arrayWithNumberArrays.get(0));
        QuickSort.quickSort(arrayWithNumberArrays.get(0), 0, Parameters.ARRAY_LENGTH - 1);
        System.out.println();
        ArrayPrinter.printArray(arrayWithNumberArrays.get(0));


    }
}
