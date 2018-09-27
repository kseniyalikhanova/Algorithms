package by.bsu.likhanova.parallelSort.sorting;

import by.bsu.likhanova.parallelSort.entity.Person;
import by.bsu.likhanova.parallelSort.entity.Worker;

public class WorkerTableSort {
    public static void sortWorkerTable(Person[] unsortedTable, Worker[] sortedTable){
        for (int i = 0; i < sortedTable.length; i++) {
            for (int j = 0; j < unsortedTable.length; j++) {
                if((sortedTable[i].getName().equals(unsortedTable[j].getName()))
                        && sortedTable[i].getAge() == unsortedTable[j].getAge()){
                    Person tmp = unsortedTable[i];
                    unsortedTable[i] = unsortedTable[j];
                    unsortedTable[j] = tmp;
                    break;
                }
            }
        }
    }
}
