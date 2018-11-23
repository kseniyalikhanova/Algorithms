package by.bsu.likhanova.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static java.util.Arrays.fill;

public class GraphWithAdjacencyMatrix {
    private int[][] adjacencyMatrix;

    public GraphWithAdjacencyMatrix(final int size) {
        adjacencyMatrix = new int[size][size];
        fill(adjacencyMatrix, int.MAX_VALUE);
        for (int i = 0; i < size; i++) {
            adjacencyMatrix[i][i] = 0;
        }
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void addEdge(final int firstVertex,
                        final int secondVertex,
                        final int weight) {
        if(weight > 0 ) {
            if (firstVertex != secondVertex
                    &&firstVertex < adjacencyMatrix.length
                    && secondVertex < adjacencyMatrix.length) {
                adjacencyMatrix[firstVertex][secondVertex] = weight;
                adjacencyMatrix[secondVertex][firstVertex] = weight;
            } else {
                System.out.println("There are no such vertices or .");
            }
        } else {
            System.out.println("Weight must be more then 0");
        }
    }

    public void removeEdge(final int firstVertex, final int secondVertex) {
        if (firstVertex != secondVertex
                && firstVertex < adjacencyMatrix.length
                && secondVertex < adjacencyMatrix.length) {
            adjacencyMatrix[firstVertex][secondVertex] = Integer.MAX_VALUE;
            adjacencyMatrix[secondVertex][firstVertex] = Integer.MAX_VALUE;
        } else {
            System.out.println("There is no such edge.");
        }
    }

    public AdjacentVertex searchEdge(final int vertex, final int adjacentVertex) {
        AdjacentVertex resultVertex = new AdjacentVertex();
        for (AdjacentVertex curVertex : adjacencyMatrix.get(vertex)) {
            if (curVertex.getVertex().equals(adjacentVertex)) {
                resultVertex = curVertex;
                break;
            }
        }
        return resultVertex;
    }

    public void clear() {
        adjacencyMatrix.clear();
    }

    @Override
    public String toString() {
        String resultString = "";
        if (adjacencyMatrix.isEmpty()) {
            resultString += "Graph is empty.";
        } else {
            resultString += "Graph{\n";
            for (Map.Entry<int, TreeSet<AdjacentVertex>> entry : adjacencyMatrix.entrySet()) {
                resultString += entry + "\n";
            }
            resultString += "}";
        }
        return resultString;
    }
}
