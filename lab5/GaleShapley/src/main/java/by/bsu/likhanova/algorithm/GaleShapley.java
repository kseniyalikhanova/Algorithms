package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.GaleShapleyData;

import java.util.*;

public class GaleShapley {

    private Map<Integer, Integer> calcMatchesByWork(GaleShapleyData data) {
        // key = worker, value = work
        Map<Integer, Integer> matches = new HashMap<>();
        List<Integer> freeWork = new LinkedList<>(data.getWorkPreference().keySet());

        while (!freeWork.isEmpty()) {
            Integer currentWork = ((LinkedList<Integer>) freeWork).pop();
            for (Map.Entry<Integer, Integer> worker
                    : data.getWorkPreference().get(currentWork).entrySet()) {
                if (matches.get(worker.getKey()) == null) {
                    matches.put(worker.getKey(), currentWork);
                    break;
                } else {
                    Integer otherWork = worker.getKey();
                    Map<Integer, Integer> works =
                            data.getWorkerPreference().get(currentWork);
                    if (works.get(currentWork) < works.get(matches.get(otherWork))) {
                        matches.put(worker.getKey(), currentWork);
                        freeWork.add(otherWork);
                        break;
                    }
                }
            }
        }
        return matches;
    }
}
