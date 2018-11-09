package by.bsu.likhanova.action;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Sorting {

    public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> map){
        Map<Integer, Integer> result = new LinkedHashMap<>();
        Stream<Map.Entry<Integer, Integer>> stream = map.entrySet().stream();
        stream.sorted(Comparator.comparing(e -> e.getValue()))
              .forEach(e -> result.put(e.getKey(),e.getValue()));
        return result;
    }
}
