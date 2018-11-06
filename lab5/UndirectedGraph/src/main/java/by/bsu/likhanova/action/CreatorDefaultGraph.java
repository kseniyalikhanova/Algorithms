package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.UndirectedGraph;

public class CreatorDefaultGraph {
    public static UndirectedGraph createDefaultGraph() {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 9);
        graph.addEdge(2, 5, 7);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 15);
        graph.addEdge(4, 6, 6);
        graph.addEdge(5, 6, 8);
        graph.addEdge(5, 7, 9);
        graph.addEdge(6, 7, 11);
        return graph;
    }
}
