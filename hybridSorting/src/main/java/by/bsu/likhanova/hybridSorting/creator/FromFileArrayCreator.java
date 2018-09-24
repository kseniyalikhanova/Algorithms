package by.bsu.likhanova.hybridSorting.creator;

import by.bsu.likhanova.hybridSorting.datareader.ReaderFromFile;
import by.bsu.likhanova.hybridSorting.parameter.Parameters;

import java.io.IOException;
import java.util.ArrayList;

public class FromFileArrayCreator {
    public static ArrayList<int[]> initArrays() throws IOException {
        ArrayList<int[]> arrayWithNumberArrays = new ArrayList<>(Parameters.FILE_AMOUNT);
        for (int i = 1; i <= Parameters.FILE_AMOUNT; i++) {
            String fileName = Parameters.FILE_NAME + i + Parameters.FILE_EXPANSION;
            arrayWithNumberArrays.add(ReaderFromFile.readArrayFromFile(fileName));
        }
        return arrayWithNumberArrays;
    }
}
