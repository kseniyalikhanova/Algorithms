package by.bsu.likhanova.entity;

import java.util.*;

public class GraphWithAdjacencyList extends UndirectedGraph {

    private Map<Integer, TreeSet<AdjacentVertex>> adjacencyList;

    public GraphWithAdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    public Map<Integer, TreeSet<AdjacentVertex>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(final Integer vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new TreeSet<>());
        } else {
            System.out.println("There is such vertex.");
        }
    }

    public void removeVertex(final Integer deletedVertex) {
        if (adjacencyList.containsKey(deletedVertex)) {
            TreeSet<AdjacentVertex> adjacencyListOfVertex = adjacencyList.get(deletedVertex);
            adjacencyList.remove(deletedVertex);
            for (AdjacentVertex vertex : adjacencyListOfVertex) {
                adjacencyList.get(vertex.getVertex()).remove(searchEdge(vertex.getVertex(), deletedVertex));
            }
        } else {
            System.out.println("There is no such vertex.");
        }

    }

    public void addEdge(final Integer firstVertex,
                        final Integer secondVertex,
                        final Integer weight) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {

            adjacencyList.get(firstVertex).add(new AdjacentVertex(secondVertex, weight));
            adjacencyList.get(secondVertex).add(new AdjacentVertex(firstVertex, weight));
        } else {
            System.out.println("There are no such vertices.");
        }
    }

    public void addEdge(final Integer firstVertex,
                        final AdjacentVertex adjacentVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(adjacentVertex.getVertex())) {

            adjacencyList.get(firstVertex).add(adjacentVertex);
            adjacencyList.get(adjacentVertex.getVertex())
                    .add(new AdjacentVertex(firstVertex, adjacentVertex.getWeight()));
        } else {
            System.out.println("There are no such vertices.");
        }
    }

    public void removeEdge(final Integer firstVertex, final Integer secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
            adjacencyList.get(firstVertex).remove(searchEdge(firstVertex,secondVertex));
            adjacencyList.get(secondVertex).remove(searchEdge(secondVertex, firstVertex));
        } else {
            System.out.println("There is no such edge.");
        }
    }

    public AdjacentVertex searchEdge(final Integer vertex, final Integer adjacentVertex) {
        AdjacentVertex resultVertex = new AdjacentVertex();
        for (AdjacentVertex curVertex : adjacencyList.get(vertex)) {
            if (curVertex.getVertex().equals(adjacentVertex)) {
                resultVertex = curVertex;
                break;
            }
        }
        return resultVertex;
    }

    public void clear() {
        adjacencyList.clear();
    }

    @Override
    public String toString() {
        String resultString = "";
        if (adjacencyList.isEmpty()) {
            resultString += "Graph is empty.";
        } else {
            resultString += "UndirectedGraph{\n";
            for (Map.Entry<Integer, TreeSet<AdjacentVertex>> entry : adjacencyList.entrySet()) {
                resultString += entry + "\n";
            }
            resultString += "}";
        }
        return resultString;
    }
}
