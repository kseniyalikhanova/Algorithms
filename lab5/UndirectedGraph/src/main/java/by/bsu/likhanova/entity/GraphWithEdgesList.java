package by.bsu.likhanova.entity;

import java.util.*;

public class GraphWithEdgesList {
    private List<Edge> edges;

    public GraphWithEdgesList() {
        edges = new LinkedList<>();
    }

    public GraphWithEdgesList(final List<Edge> newEdges) {
        this.edges = newEdges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(final int firstVertex,
                        final int secondVertex,
                        final int weight) {
        Edge edge = new Edge(firstVertex, secondVertex, weight);
        if (!edges.contains(edge)) {
            edges.add(edge);
        } else {
            System.out.println("There is such edge.");
        }
    }

    public void addEdge(final Edge edge) {
        if (!edges.contains(edge)) {
            edges.add(edge);
        } else {
            System.out.println("There is such edge.");
        }
    }

    public void removeEdge(final Edge edge) {
        if (edges.contains(edge)) {
            edges.remove(edge);
        } else {
            System.out.println("There isn't such edge.");
        }
    }

    public void removeEdge(final int firstVertex,
                           final int secondVertex,
                           final int weight) {
        Edge edge = new Edge(firstVertex, secondVertex, weight);
        if (!edges.contains(edge)) {
            edges.remove(edge);
        } else {
            System.out.println("There isn't such edge.");
        }
    }

    public Set<Integer> getVertices() {
        Set<Integer> vertices = new HashSet<>();
        for (Edge edge : edges) {
            vertices.add(edge.getFirstVertex());
            vertices.add(edge.getSecondVertex());
        }
        return vertices;
    }

    public void clear(){
        edges.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphWithEdgesList graph = (GraphWithEdgesList) o;
        return Objects.equals(edges, graph.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edges);
    }

    @Override
    public String toString() {
    return "GraphWithEdgesList{ "
                + edges +
                '}';
    }
}
