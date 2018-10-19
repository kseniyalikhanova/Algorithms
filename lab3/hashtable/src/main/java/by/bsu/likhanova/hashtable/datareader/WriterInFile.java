package by.bsu.likhanova.hashtable.datareader;

import by.bsu.likhanova.hashtable.creator.RandomArrayCreator;

import java.io.*;

public class WriterInFile {

    public static void writeArrayInFile(String fileName) throws IOException {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(fileName, false)))) {
            int[] array = RandomArrayCreator.initArray();
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]));
                writer.write(" ");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IOException();
        }

    }
}

