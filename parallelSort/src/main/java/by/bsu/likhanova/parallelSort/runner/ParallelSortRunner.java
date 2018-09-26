package by.bsu.likhanova.parallelSort.runner;

import by.bsu.likhanova.parallelSort.entity.ChiefTable;
import by.bsu.likhanova.parallelSort.entity.Worker;
import by.bsu.likhanova.parallelSort.entity.WorkerTable;
import by.bsu.likhanova.parallelSort.sorting.MergeSort;

public class ParallelSortRunner {
    public static void main(String[] args) {
        Worker[] workers = new Worker[10];
        workers[0] = new Worker("Kseniya", 19, 3000);
        workers[1] = new Worker("Max", 35, 2000);
        workers[2] = new Worker("Vitaly", 29, 2500);
        workers[3] = new Worker("Kate", 24, 1500);
        workers[4] = new Worker("Mike", 33, 3500);
        workers[5] = new Worker("Olga", 22, 1000);
        workers[6] = new Worker("Ivan", 37, 4000);
        workers[7] = new Worker("Tatyana", 45, 5000);
        workers[8] = new Worker("Alex", 18, 1700);
        workers[9] = new Worker("Anton", 26, 3100);

        ChiefTable chiefTable = new ChiefTable(workers);
        WorkerTable workerTable = new WorkerTable(workers);

        MergeSort.mergeSort(chiefTable.getWorkers(), 0, chiefTable.getWorkers().length - 1);
        System.out.println(chiefTable);
    }
}
