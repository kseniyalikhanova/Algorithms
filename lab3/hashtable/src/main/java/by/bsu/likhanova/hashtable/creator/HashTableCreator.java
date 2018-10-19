package by.bsu.likhanova.hashtable.creator;

import by.bsu.likhanova.hashtable.entity.HashTable;

public class HashTableCreator {
    public static HashTable initHashTable(int[] array, double irrational) {
        HashTable hashTable = new HashTable(irrational);
        for (int i = 0; i < array.length; i++) {
            hashTable.add(array[i]);
        }
        return hashTable;
    }
}
