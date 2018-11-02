package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.UndirectedGraph;

public class CreatorDefaultGraph {

    public static UndirectedGraph createDefaultGraph(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 7);
        graph.addEdge(6, 4);
        graph.addEdge(6, 7);
        return graph;
    }
}
