package by.bsu.likhanova.parallelSort.runner;

import by.bsu.likhanova.parallelSort.entity.ChiefTable;
import by.bsu.likhanova.parallelSort.entity.WorkerTable;
import by.bsu.likhanova.parallelSort.initialiser.TableInitialiser;
import by.bsu.likhanova.parallelSort.sorting.MergeSort;
import by.bsu.likhanova.parallelSort.sorting.ParallelSort;
import by.bsu.likhanova.parallelSort.sorting.WorkerTableSort;

public class ParallelSortRunner {
    public static void main(String[] args) {

        ChiefTable chiefTable = new ChiefTable(TableInitialiser.initializeChiefTable());
        WorkerTable workerTable = new WorkerTable(TableInitialiser.initializeWorkerTable());

        MergeSort.mergeSort(chiefTable.getWorkers(),0,chiefTable.getWorkers().length - 1);
        System.out.println(chiefTable);
        WorkerTableSort.sortWorkerTable(workerTable.getWorkers(),chiefTable.getWorkers());
        System.out.println(workerTable);

        chiefTable.setWorkers(TableInitialiser.initializeChiefTable());
        workerTable.setWorkers(TableInitialiser.initializeWorkerTable());

        ParallelSort parallelSort = new ParallelSort(workerTable.getWorkers());
        parallelSort.parallelSort(chiefTable.getWorkers(), 0,chiefTable.getWorkers().length - 1);
        System.out.println(chiefTable);
        System.out.println(workerTable);
        
    }
}
