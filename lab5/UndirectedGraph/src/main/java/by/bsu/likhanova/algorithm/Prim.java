package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.action.ActionWithGraph;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Prim {
    public static GraphWithAdjacencyList searchMinimalSkeletonGraph(final GraphWithAdjacencyList graph) {
        GraphWithAdjacencyList minimalSkeletonGraph = new GraphWithAdjacencyList();
        List<Integer> unusedVertices = new LinkedList<>();
        unusedVertices.addAll(graph.getAdjacencyList().keySet());

        minimalSkeletonGraph.addVertex(((LinkedList<Integer>) unusedVertices).getFirst());
        unusedVertices.remove(0);

        while (!unusedVertices.isEmpty()){
            Integer[] minEdge = ActionWithGraph.searchMinEdge(graph, unusedVertices,
                                          minimalSkeletonGraph.getAdjacencyList().keySet());
            minimalSkeletonGraph.addVertex(minEdge[0]);
            minimalSkeletonGraph.addEdge(minEdge[0],
                                         graph.searchEdge(minEdge[0], minEdge[1]));
            unusedVertices.remove(minEdge[0]);
        }


        return minimalSkeletonGraph;
    }
}
