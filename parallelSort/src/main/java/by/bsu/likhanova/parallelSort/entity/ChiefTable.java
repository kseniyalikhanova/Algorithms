package by.bsu.likhanova.parallelSort.entity;

public class ChiefTable {
    private Worker[] workers;

    public ChiefTable() {
        workers = new Worker[10];
    }

    public ChiefTable(Worker[] workers) {
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
            result = result.concat(worker.toString());
        }
        return result;
    }
}
