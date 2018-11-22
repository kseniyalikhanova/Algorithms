package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.GraphWithAdjacencyList;

public class CreatorDefaultGraph {

    public static GraphWithAdjacencyList createDefaultGraph() {
        GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 6, 14);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 15);
        graph.addEdge(3, 4, 11);
        graph.addEdge(3, 6, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(6, 5, 9);
        return graph;
    }
}
