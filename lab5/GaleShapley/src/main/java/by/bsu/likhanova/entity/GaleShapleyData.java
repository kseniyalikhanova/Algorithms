package by.bsu.likhanova.entity;

import by.bsu.likhanova.action.Sorting;

import java.util.*;

public class GaleShapleyData {
    private Map<Integer, Map<Integer, Integer>> workPreference;
    private Map<Integer, Map<Integer, Integer>> workerPreference;

    public GaleShapleyData(Map<Integer, Map<Integer, Integer>> workPreference,
                           Map<Integer, Map<Integer, Integer>> workerPreference) {
        this.workPreference = new HashMap<>();
        setWorkPreference(workPreference);
        this.workerPreference = new HashMap<>();
        setWorkerPreference(workerPreference);

    }

    public Map<Integer, Map<Integer, Integer>> getWorkPreference() {
        return workPreference;
    }

    public void setWorkPreference(final  Map<Integer, Map<Integer, Integer>> workPreference) {
        for (Map.Entry<Integer, Map<Integer, Integer>> work : workPreference.entrySet()) {
            this.workPreference.put(work.getKey(), Sorting.sortMapByValue(work.getValue()));
        }
    }

    public Map<Integer, Map<Integer, Integer>> getWorkerPreference() {
        return workerPreference;
    }

    public void setWorkerPreference(final  Map<Integer, Map<Integer, Integer>> workerPreference) {
        for (Map.Entry<Integer, Map<Integer, Integer>> worker : workerPreference.entrySet()) {
            this.workerPreference.put(worker.getKey(), Sorting.sortMapByValue(worker.getValue()));
        }
    }
}