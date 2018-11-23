package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.GraphWithAdjacencyMatrix;

import static java.lang.Integer.min;

public class Floyd {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static GraphWithAdjacencyMatrix perform(final GraphWithAdjacencyMatrix graph) {
        GraphWithAdjacencyMatrix resultGraph = graph;
        for (int k = 0; k < graph.getSize(); ++k) {
            for (int i = 0; i < graph.getSize(); ++i) {
                for (int j = 0; j < graph.getSize(); ++j) {
                    if (resultGraph.getAdjacencyMatrix()[i][k] < INFINITY
                            && resultGraph.getAdjacencyMatrix()[k][j] < INFINITY) {
                        resultGraph.getAdjacencyMatrix()[i][j] =
                                min(resultGraph.getAdjacencyMatrix()[i][j],
                                  resultGraph.getAdjacencyMatrix()[i][k]
                                      + resultGraph.getAdjacencyMatrix()[k][j]);
                    }
                }
            }
        }
        return resultGraph;
    }
}
