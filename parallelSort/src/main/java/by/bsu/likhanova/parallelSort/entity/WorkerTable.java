package by.bsu.likhanova.parallelSort.entity;

import java.util.ArrayList;

public class WorkerTable {
    private ArrayList<Worker> workers;

    public  WorkerTable(){
        workers = new ArrayList<>();
    }
    public WorkerTable(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers.addAll(workers);
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public String toString() {
        String result = "";
        for (Worker worker : workers) {
            result += worker.toString(false);
        }
        return result;
    }
}
