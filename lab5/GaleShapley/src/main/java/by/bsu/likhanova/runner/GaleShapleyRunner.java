package by.bsu.likhanova.runner;

import by.bsu.likhanova.action.CalculationParameter;
import by.bsu.likhanova.algorithm.GaleShapley;
import by.bsu.likhanova.entity.GaleShapleyData;

import java.util.HashMap;
import java.util.Map;

public class GaleShapleyRunner {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> workPreference = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> workerPreference = new HashMap<>();
        Map<Integer, Integer> list = new HashMap<>();


        list.put(1,5);
        list.put(2,2);
        list.put(3,3);
        list.put(4,1);
        list.put(5,4);
        workPreference.put(1, list);
        list = new HashMap<>();;

        list.put(1,2);
        list.put(2,5);
        list.put(3,3);
        list.put(4,2);
        list.put(5,1);
        workPreference.put(2, list);
        list = new HashMap<>();;

        list.put(1,5);
        list.put(2,3);
        list.put(3,4);
        list.put(4,1);
        list.put(5,2);
        workPreference.put(3, list);
        list = new HashMap<>();;

        list.put(1,5);
        list.put(2,3);
        list.put(3,1);
        list.put(4,4);
        list.put(5,2);
        workPreference.put(4, list);
        list = new HashMap<>();;

        list.put(1,4);
        list.put(2,2);
        list.put(3,1);
        list.put(4,3);
        list.put(5,5);
        workPreference.put(5, list);
        list = new HashMap<>();;

        ////////////

        list.put(1,3);
        list.put(2,2);
        list.put(3,1);
        list.put(4,4);
        list.put(5,5);
        workerPreference.put(1, list);
        list = new HashMap<>();;

        list.put(1,5);
        list.put(2,4);
        list.put(3,3);
        list.put(4,1);
        list.put(5,2);
        workerPreference.put(2, list);
        list = new HashMap<>();;

        list.put(1,1);
        list.put(2,2);
        list.put(3,3);
        list.put(4,5);
        list.put(5,4);
        workerPreference.put(3, list);
        list = new HashMap<>();;

        list.put(1,4);
        list.put(2,5);
        list.put(3,3);
        list.put(4,1);
        list.put(5,2);
        workerPreference.put(4, list);
        list = new HashMap<>();;

        list.put(1,1);
        list.put(2,2);
        list.put(3,3);
        list.put(4,4);
        list.put(5,5);
        workerPreference.put(5, list);
        list = new HashMap<>();;

        ///
        GaleShapleyData galeShapleyData = new GaleShapleyData(workPreference, workerPreference);
        System.out.println("workPreference = " + galeShapleyData.getWorkPreference());
        System.out.println("workerPreference = " + galeShapleyData.getWorkerPreference());
        System.out.println("Gale-Shapley by workPreference = "
                + GaleShapley.calcMatches(galeShapleyData.getWorkPreference(), galeShapleyData.getWorkerPreference()));
        System.out.println("Gale-Shapley by workerPreference = "
                + GaleShapley.calcMatches(galeShapleyData.getWorkerPreference(), galeShapleyData.getWorkPreference()));
        System.out.println("Parameter by work = " + CalculationParameter.calcEfficiencyParameter(
                GaleShapley.calcMatches(galeShapleyData.getWorkPreference(), galeShapleyData.getWorkerPreference()),
                galeShapleyData.getWorkPreference()));
        System.out.println("Parameter by worker = " + CalculationParameter.calcEfficiencyParameter(
                GaleShapley.calcMatches(galeShapleyData.getWorkerPreference(), galeShapleyData.getWorkPreference()),
                galeShapleyData.getWorkerPreference()));
    }

}
