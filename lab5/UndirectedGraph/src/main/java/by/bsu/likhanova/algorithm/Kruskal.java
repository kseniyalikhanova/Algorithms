package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.DSU;
import by.bsu.likhanova.entity.Edge;
import by.bsu.likhanova.entity.UndirectedGraph;

import static java.util.Collections.sort;

public class Kruskal {
    public static UndirectedGraph searchMinimalSkeletonGraph(final UndirectedGraph graph) {
        DSU dsu = new DSU(graph.getVertices().size());
        sort(graph.getEdges());
        UndirectedGraph minimalSkeletonGraph = new UndirectedGraph();
        for (Edge edge : graph.getEdges()) {
            if (dsu.unite(edge.getFirstVertex(), edge.getSecondVertex())) {
                minimalSkeletonGraph.addEdge(edge);
            }
        }
        return minimalSkeletonGraph;
    }
}
