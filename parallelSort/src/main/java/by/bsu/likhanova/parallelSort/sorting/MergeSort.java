package by.bsu.likhanova.parallelSort.sorting;

import by.bsu.likhanova.parallelSort.entity.Worker;

public class MergeSort {
    public static void mergeSort(Worker[] workers, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(workers, left, middle);
            mergeSort(workers, middle + 1, right);
            merge(workers, left, middle, right);
        }
    }

    private static void merge(Worker[] workers, int left, int middle, int right) {
        Worker[] helper = new Worker[workers.length];
        for (int i = left; i <= right; i++) {
            helper[i] = workers[i];
        }

        int helperLeft = left;
        int helperRight = middle + 1;
        int current = left;

        while (helperLeft <= middle && helperRight <= right) {
            if (helper[helperLeft].getSalary() <= helper[helperRight].getSalary()) {
                workers[current] = helper[helperLeft];
                helperLeft++;

            } else {
                workers[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        for (int i = 0; helperLeft <= middle; i++, helperLeft++) {
            workers[current + i] = helper[helperLeft];
        }
        for (int i = 0; helperRight <= right; i++, helperRight++) {
            workers[current + i] = helper[helperRight];
        }
    }
}
