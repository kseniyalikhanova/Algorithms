package by.bsu.likhanova.hashtable.datareader;

import by.bsu.likhanova.hashtable.parameter.Parameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReaderFromFile {
    public static int[] readArrayFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        int[] array = new int[Parameters.ARRAY_LENGTH];
        try (Scanner scanner = new Scanner(path)) {
            for (int i = 0; i < array.length && scanner.hasNextInt(); i++) {
                array[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new FileNotFoundException();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new IOException();
        }
        return array;
    }
}