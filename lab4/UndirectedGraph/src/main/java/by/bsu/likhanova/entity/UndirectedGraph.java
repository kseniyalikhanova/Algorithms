package by.bsu.likhanova.entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedGraph {
    private Map<Integer, LinkedList<Integer>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public Map<Integer, LinkedList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(Integer vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(int deletedVertex){
            if (adjacencyList.containsKey(deletedVertex)) {
                LinkedList<Integer> adjacencyListOfVertex = adjacencyList.get(deletedVertex);
                adjacencyList.remove(deletedVertex);
                for (Integer vertex : adjacencyListOfVertex) {
                    adjacencyList.get(vertex).remove(deletedVertex);
                }
            } else {
                System.out.println("there is no such vertex.");
            }

    }

    public void addEdge(Integer firstVertex, Integer secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {
            adjacencyList.get(firstVertex).add(secondVertex);
            adjacencyList.get(secondVertex).add(firstVertex);
        } else {
            System.out.println("There are no such vertices.");
        }
    }

    public void removeEdge(Integer firstVertex, Integer secondVertex) {
        if (adjacencyList.containsKey(firstVertex)
            && adjacencyList.containsKey(secondVertex)) {
            adjacencyList.get(firstVertex).remove(secondVertex);
            adjacencyList.get(secondVertex).remove(firstVertex);
        } else {
            System.out.println("There is no such edge.");
        }
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
