package by.bsu.likhanova.parallelSort.runner;

import by.bsu.likhanova.parallelSort.entity.ChiefTable;
import by.bsu.likhanova.parallelSort.entity.Worker;
import by.bsu.likhanova.parallelSort.entity.WorkerTable;

import java.util.ArrayList;

public class ParallelSortRunner {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>(10);
        workers.add(new Worker("Kseniya", 19, 3000));
        workers.add(new Worker("Max", 35, 2000));
        workers.add(new Worker("Vitaly", 29, 2500));
        workers.add(new Worker("Kate", 24, 1500));
        workers.add(new Worker("Mike", 33, 3500));
        workers.add(new Worker("Olga", 22, 1000));
        workers.add(new Worker("Ivan", 37, 4000));
        workers.add(new Worker("Tatyana", 45, 5000));
        workers.add(new Worker("Alex", 18, 1700));
        workers.add(new Worker("Anton", 26, 3100));

        ChiefTable chiefTable = new ChiefTable(workers);
        WorkerTable workerTable = new WorkerTable(workers);
    }
}
