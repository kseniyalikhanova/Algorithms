package by.bsu.likhanova.searchInSortedArray.action;

import java.util.ArrayList;

public class RandomNumbers {
    public static int generateRandomNumber(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static ArrayList<Integer> generateRandomArray(int capacity, int min, int max){
        ArrayList<Integer> array = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            array.add(generateRandomNumber(min,max));
        }
        return array;
    }
}
