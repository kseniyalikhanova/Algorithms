package by.bsu.likhanova.entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedGraph {
    private Map<Vertex, LinkedList<Vertex>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public Map<Vertex, LinkedList<Vertex>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(final Vertex vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new LinkedList<>());
        } else {
            System.out.println("There is such vertex.");
        }
    }

    public void removeVertex(final Vertex deletedVertex) {
        if (adjacencyList.containsKey(deletedVertex)) {
            LinkedList<Vertex> adjacencyListOfVertex = adjacencyList.get(deletedVertex);
            adjacencyList.remove(deletedVertex);
            for (Vertex vertex : adjacencyListOfVertex) {
                adjacencyList.get(vertex).remove(deletedVertex);
            }
        } else {
            System.out.println("There is no such vertex.");
        }

    }

    public void addEdge(final Vertex firstVertex, final Vertex secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
            adjacencyList.get(firstVertex).add(secondVertex);
            adjacencyList.get(secondVertex).add(firstVertex);
        } else {
            System.out.println("There are no such vertices.");
        }
    }

    public void removeEdge(final Vertex firstVertex, final Vertex secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
            adjacencyList.get(firstVertex).remove(secondVertex);
            adjacencyList.get(secondVertex).remove(firstVertex);
        } else {
            System.out.println("There is no such edge.");
        }
    }

    public void markEdge(final Vertex firstVertex, final Vertex secondVertex) {
            adjacencyList.get(firstVertex).get(searchEdge(firstVertex, secondVertex)).setMarked();
            adjacencyList.get(secondVertex).get(searchEdge(secondVertex, firstVertex)).setMarked();
    }

    public int searchEdge(final Vertex vertex, final Vertex adjacentVertex) {
        int resultVertex = -1;
        LinkedList<Vertex> vertices = adjacencyList.get(vertex);
        if (adjacencyList.containsKey(vertex)
                && adjacencyList.containsKey(adjacentVertex)) {
            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).equals(adjacentVertex)) {
                    resultVertex = i;
                    break;
                }
            }
        } else {
            System.out.println("There is no such edge.");
        }
        return resultVertex;
    }

    public void clear() {
        adjacencyList.clear();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        if (adjacencyList.isEmpty()) {
            resultString.append("Graph is empty.");
        } else {
            resultString.append("UndirectedGraph{ ");
            resultString.append(adjacencyList);
            resultString.append(" }");
        }
        return resultString.toString();
    }
}
