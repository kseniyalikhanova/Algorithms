package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.GraphWithAdjacencyMatrix;

public class Searching {
    public static int searchOptimalLocationOfFireStation(GraphWithAdjacencyMatrix graph) {
        int optimalLocation = Integer.MAX_VALUE;
        int maxTimeOfOptimalLocation = -1;
        for (int i = 0; i < graph.getAdjacencyMatrix().length; i++) {
            int maxTime = -1;
            for (int j = 0; j < graph.getAdjacencyMatrix().length; j++) {
                if(maxTime < graph.getAdjacencyMatrix()[i][j]){
                    maxTime = graph.getAdjacencyMatrix()[i][j];
                }
            }
            if (maxTimeOfOptimalLocation > maxTime) {
                maxTimeOfOptimalLocation = maxTime;
                optimalLocation = i;
            }
        }
        return optimalLocation;
    }
}
