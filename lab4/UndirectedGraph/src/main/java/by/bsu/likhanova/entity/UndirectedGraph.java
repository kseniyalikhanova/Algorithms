package by.bsu.likhanova.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedGraph {
    private Map<Integer, LinkedList<Integer[]>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public Map<Integer, LinkedList<Integer[]>> getAdjacencyList() {
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
            LinkedList<Integer[]> adjacencyListOfVertex = adjacencyList.get(deletedVertex);
            adjacencyList.remove(deletedVertex);
            for (Integer[] vertex : adjacencyListOfVertex) {
                adjacencyList.get(vertex[0]).remove(searchEdge(vertex[0], deletedVertex));
            }
        } else {
            System.out.println("There is no such vertex.");
        }

    }

    public void addEdge(final Integer firstVertex, final Integer secondVertex) {
        Integer[] vertex1 = {firstVertex, 0};
        Integer[] vertex2 = {secondVertex, 0};
        if (adjacencyList.containsKey(firstVertex)
                && adjacencyList.containsKey(secondVertex)) {

            adjacencyList.get(firstVertex).add(vertex2);
            adjacencyList.get(secondVertex).add(vertex1);
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

    public void markEdge(final Integer firstVertex, final Integer secondVertex) {
        adjacencyList.get(firstVertex).get(searchEdge(firstVertex, secondVertex))[1] = 1;
        adjacencyList.get(secondVertex).get(searchEdge(secondVertex, firstVertex))[1] = 1;
    }

    public int searchEdge(final Integer vertex, final Integer adjacentVertex) {
        int resultVertex = -1;
        LinkedList<Integer[]> vertices = adjacencyList.get(vertex);

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i)[0].equals(adjacentVertex)) {
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
        StringBuilder resultString = new StringBuilder();
        if (adjacencyList.isEmpty()) {
            resultString.append("Graph is empty.");
        } else {
            resultString.append("UndirectedGraph{\n");
            for (Map.Entry<Integer, LinkedList<Integer[]>> entry : adjacencyList.entrySet()) {
                resultString.append("[");
                resultString.append(entry.getKey());
                resultString.append(" = {");
                for (Integer[] vertex : entry.getValue()) {
                    resultString.append(vertex[0]);
                    resultString.append(",");
                }
                resultString.deleteCharAt(resultString.length() -1);
                resultString.append("}], ");
            }
            resultString.deleteCharAt(resultString.length() - 2);
            resultString.append("}");
        }
        return resultString.toString();
    }
}
