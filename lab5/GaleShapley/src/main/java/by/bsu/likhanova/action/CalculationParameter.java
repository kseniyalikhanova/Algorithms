package by.bsu.likhanova.action;

import java.util.Map;

public class CalculationParameter {
    public static int calcEfficiencyParameter(Map<Integer, Integer> matches,
                                              Map<Integer, Map<Integer, Integer>> preference){
        int efficiencyParameter = 0;
        for (Map.Entry<Integer, Integer> entry1 : matches.entrySet()) {
            int value = entry1.getValue();
            int i = 1;
            for (Map.Entry<Integer, Integer>  entry2: preference.get(value).entrySet()){
                if (entry2.getValue().equals(value)){
                    break;
                }
                i++;
            }
            int key = preference.get(value).keySet().iterator().next();
            efficiencyParameter += value - preference.get(value).get(key);
        }
        return efficiencyParameter;
    }
}
