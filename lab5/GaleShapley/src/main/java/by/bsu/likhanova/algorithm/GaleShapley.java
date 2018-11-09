package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.GaleShapleyData;

import java.util.*;

public class GaleShapley {

    public static Map<Integer, Integer> calcMatches(Map<Integer, Map<Integer, Integer>> menPreference,
                                                    Map<Integer, Map<Integer, Integer>> womenPreference) {
        // key = woman, value = man
        Map<Integer, Integer> matches = new HashMap<>();
        List<Integer> freeMen = new LinkedList<>(menPreference.keySet());

        while (!freeMen.isEmpty()) {
            Integer currentMan = ((LinkedList<Integer>) freeMen).pop();
            for (Map.Entry<Integer, Integer> woman
                    : menPreference.get(currentMan).entrySet()) {
                if (matches.get(woman.getKey()) == null) {
                    matches.put(woman.getKey(), currentMan);
                    break;
                } else {
                    Integer otherMan = matches.get(woman.getKey());
                    Map<Integer, Integer> men =
                            womenPreference.get(woman.getKey());
                     if (men.get(currentMan) < men.get(otherMan)) {
                        matches.put(woman.getKey(), currentMan);
                        freeMen.add(otherMan);
                        break;
                    }
                }
            }
        }
        return matches;
    }
}
