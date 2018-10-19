package by.bsu.likhanova.hashtable.runner;

import by.bsu.likhanova.hashtable.creator.FromFileArrayCreator;
import by.bsu.likhanova.hashtable.creator.HashTableCreator;
import by.bsu.likhanova.hashtable.datareader.WriterInFile;
import by.bsu.likhanova.hashtable.entity.HashTable;
import by.bsu.likhanova.hashtable.parameter.Parameters;

import java.io.IOException;
import java.util.ArrayList;

public class HashTableRunner {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= Parameters.FILE_AMOUNT; i++) {
            String fileName = Parameters.FILE_NAME + i + Parameters.FILE_EXPANSION;
            WriterInFile.writeArrayInFile(fileName);
        }
        ArrayList<int[]> arrayWithHashTable = FromFileArrayCreator.initArrays();
        int avarageCollisionListLength = 0;
        HashTable hashTable;
        for (int[] array : arrayWithHashTable) {
            hashTable = HashTableCreator.initHashTable(array, Parameters.KNUT_NUMBER);
            avarageCollisionListLength += hashTable.maxCollisionListLength();
        }
        System.out.println("Hash table with KNUT_NUMBER has maxCollisionListLength = "
                + (avarageCollisionListLength / Parameters.FILE_AMOUNT));

        avarageCollisionListLength = 0;
        for (int[] array : arrayWithHashTable) {
            hashTable = HashTableCreator.initHashTable(array, Parameters.QUOTIENT_FROM_LN_BASIS_AND_PI);
            avarageCollisionListLength += hashTable.maxCollisionListLength();
        }
        System.out.println("Hash table with QUOTIENT_FROM_LN_BASIS_AND_PI has maxCollisionListLength = "
                + (avarageCollisionListLength / Parameters.FILE_AMOUNT));

        avarageCollisionListLength = 0;
        for (int[] array : arrayWithHashTable) {
            hashTable = HashTableCreator.initHashTable(array, Parameters.QUOTIENT_FROM_SQRT_2_AND_3);
            avarageCollisionListLength += hashTable.maxCollisionListLength();
        }
        System.out.println("Hash table with QUOTIENT_FROM_SQRT_2_AND_3 has maxCollisionListLength = "
                + (avarageCollisionListLength / Parameters.FILE_AMOUNT));

        avarageCollisionListLength = 0;
        for (int[] array : arrayWithHashTable) {
            hashTable = HashTableCreator.initHashTable(array, Parameters.QUOTIENT_FROM_SQRT2_AND_2);
            avarageCollisionListLength += hashTable.maxCollisionListLength();
        }
        System.out.println("Hash table with QUOTIENT_FROM_SQRT2_AND_2 has maxCollisionListLength = "
                + (avarageCollisionListLength / Parameters.FILE_AMOUNT));

        hashTable = HashTableCreator.initHashTable(arrayWithHashTable.get(0), Parameters.QUOTIENT_FROM_LN_BASIS_AND_PI);
        System.out.println(hashTable);
        System.out.println(hashTable.isContains(282));
        System.out.println(hashTable.isContains(1001));
    }
}
