package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.DSU;
import by.bsu.likhanova.entity.Edge;
import by.bsu.likhanova.entity.GraphWithEdgesList;

import static java.util.Collections.sort;

public class Kruskal {
    public static GraphWithEdgesList searchMinimalSkeletonGraph(final GraphWithEdgesList graph) {
        DSU dsu = new DSU(graph.getVertices().size());
        sort(graph.getEdges());
        GraphWithEdgesList minimalSkeletonGraph = new GraphWithEdgesList();
        for (Edge edge : graph.getEdges()) {
            if (dsu.unite(edge.getFirstVertex(), edge.getSecondVertex())) {
                minimalSkeletonGraph.addEdge(edge);
            }
        }
        return minimalSkeletonGraph;
    }
}
