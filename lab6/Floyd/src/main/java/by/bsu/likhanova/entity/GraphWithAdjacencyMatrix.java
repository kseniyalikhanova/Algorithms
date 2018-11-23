package by.bsu.likhanova.entity;

import static java.util.Arrays.fill;

public class GraphWithAdjacencyMatrix {
    private int size;
    private int[][] adjacencyMatrix;

    public GraphWithAdjacencyMatrix(final int newSize) {
        this.size = newSize;
        adjacencyMatrix = new int[size][size];
        fill(adjacencyMatrix, Integer.MAX_VALUE);
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
        if (weight > 0) {
            if (firstVertex != secondVertex
                    && firstVertex < adjacencyMatrix.length
                    && secondVertex < adjacencyMatrix.length) {
                adjacencyMatrix[firstVertex][secondVertex] = weight;
                adjacencyMatrix[secondVertex][firstVertex] = weight;
            } else {
                System.out.println("There are no such vertices or this is the same vertex.");
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

    public void clear() {
        fill(adjacencyMatrix, Integer.MAX_VALUE);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacencyMatrix[i][i] = 0;
        }
    }

    @Override
    public String toString() {
        String resultString = "";
        resultString += "Graph{\n";
        for (int i = 1; i <= adjacencyMatrix.length; i++) {
            resultString += "   " + i;
        }
        resultString += "\n";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (i == 0) {
                resultString += "   __";
            } else {
                resultString += "_____";
            }
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                resultString += i + " | " + adjacencyMatrix[i][j];
            }
        }
        resultString += "}";

        return resultString;
    }
}
