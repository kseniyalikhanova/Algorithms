package by.bsu.likhanova.entity;

import static java.util.Arrays.fill;

public class GraphWithAdjacencyMatrix {
    private static final int INFINITY = Integer.MAX_VALUE;
    private int size;
    private int[][] adjacencyMatrix;

    public GraphWithAdjacencyMatrix(final int newSize) {
        this.size = newSize;
        adjacencyMatrix = new int[size][size];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            fill(adjacencyMatrix[i], INFINITY);
        }
        for (int i = 0; i < size; i++) {
            adjacencyMatrix[i][i] = 0;
        }
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getSize() {
        return size;
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
            adjacencyMatrix[firstVertex][secondVertex] = INFINITY;
            adjacencyMatrix[secondVertex][firstVertex] = INFINITY;
        } else {
            System.out.println("There is no such edge.");
        }
    }

    public void clear() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            fill(adjacencyMatrix[i], INFINITY);
        }
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
        resultString += "\n";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            resultString += i + 1 + " | ";
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != INFINITY) {
                    resultString += adjacencyMatrix[i][j] + " ";
                } else {
                    resultString += "null ";
                }
            }
            resultString += "\n";
        }
        resultString += "}";

        return resultString;
    }
}
