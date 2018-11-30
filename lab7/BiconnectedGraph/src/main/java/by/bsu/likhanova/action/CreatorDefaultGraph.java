package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.GraphWithAdjacencyList;

public class CreatorDefaultGraph {

    public static void createDefaultGraph(GraphWithAdjacencyList graph){
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
    }

    public static void createDefaultTree(GraphWithAdjacencyList graph){
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);
    }
}
