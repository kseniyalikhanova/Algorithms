package by.bsu.likhanova.entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphWithAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphWithAdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(final Integer vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new LinkedList<>());
        } else {
            System.out.println("There is such vertex.");
        }
    }

    public void removeVertex(final Integer deletedVertex) {
        if (adjacencyList.containsKey(deletedVertex)) {
            List<Integer> adjacencyListOfVertex = adjacencyList.get(deletedVertex);
            adjacencyList.remove(deletedVertex);
            for (Integer vertex : adjacencyListOfVertex) {
                adjacencyList.get(vertex).remove(searchEdge(vertex, deletedVertex));
            }
        } else {
            System.out.println("There is no such vertex.");
        }

    }

    public int getVertexAmount() {
        return adjacencyList.keySet().size();
    }

    public void addEdge(final Integer firstVertex, final Integer secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
            if(!adjacencyList.get(firstVertex).contains(secondVertex)) {
                adjacencyList.get(firstVertex).add(secondVertex);
                if (!firstVertex.equals(secondVertex)) {
                    adjacencyList.get(secondVertex).add(firstVertex);
                }
            } else {
                System.out.println("There is such edge.");
            }
        } else {
            System.out.println("There are no such vertices.");
        }
    }

    public void removeEdge(final Integer firstVertex, final Integer secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
                adjacencyList.get(firstVertex).remove(searchEdge(firstVertex,secondVertex));
            if (!firstVertex.equals(secondVertex)) {
                adjacencyList.get(secondVertex).remove(searchEdge(secondVertex, firstVertex));
            }
        } else {
            System.out.println("There is no such edge.");
        }
    }

    public int searchEdge(final Integer vertex, final Integer adjacentVertex) {
        int resultVertex = -1;
        List<Integer> vertices = adjacencyList.get(vertex);

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(adjacentVertex)) {
                resultVertex = i;
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
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                resultString += entry.getKey() + " = {";
                for (Integer vertex : entry.getValue()) {
                    resultString += vertex + ",";
                }
                resultString += "}, ";
            }
            resultString += "}";
        }
        return resultString;
    }
}
