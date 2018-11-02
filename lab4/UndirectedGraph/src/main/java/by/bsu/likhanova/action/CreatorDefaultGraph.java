package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.UndirectedGraph;
import by.bsu.likhanova.entity.Vertex;

public class CreatorDefaultGraph {

    public static UndirectedGraph createDefaultGraph(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));
        graph.addVertex(new Vertex(5));
        graph.addVertex(new Vertex(6));
        graph.addVertex(new Vertex(7));
        graph.addEdge(new Vertex(1), new Vertex(2));
        graph.addEdge(new Vertex(1), new Vertex(4));
        graph.addEdge(new Vertex(2), new Vertex(3));
        graph.addEdge(new Vertex(2), new Vertex(4));
        graph.addEdge(new Vertex(2), new Vertex(5));
        graph.addEdge(new Vertex(5), new Vertex(3));
        graph.addEdge(new Vertex(5), new Vertex(4));
        graph.addEdge(new Vertex(5), new Vertex(7));
        graph.addEdge(new Vertex(6), new Vertex(4));
        graph.addEdge(new Vertex(6), new Vertex(7));
        return graph;
    }
}
