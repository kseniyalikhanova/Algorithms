package by.bsu.likhanova.hashtable.creator;

import by.bsu.likhanova.hashtable.parameter.Parameters;

import java.util.Random;

public class RandomArrayCreator {
    private static Random random = new Random();

    public static int[] initArray() {
        int[] array = new int[Parameters.ARRAY_LENGTH];
        for (int i = 0; i < Parameters.ARRAY_LENGTH; i++) {
            array[i] = random.nextInt(Parameters.VALUE_RANGE);
        }
        return array;
    }
}
