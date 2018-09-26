package by.bsu.likhanova.parallelSort.entity;

public class WorkerTable {
    private Worker[] workers;

    public WorkerTable() {
        workers = new Worker[10];
    }

    public WorkerTable(Worker[] workers) {
        this.workers = workers;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        String result = "";
        for (Worker worker : workers) {
            result = result.concat(worker.toString(false));
        }
        return result;
    }
}
