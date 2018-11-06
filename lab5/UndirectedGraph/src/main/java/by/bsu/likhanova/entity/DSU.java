package by.bsu.likhanova.entity;

/**
 * The type Dsu = disjoint set union.
 */
public class DSU {
    private int componentNumber[];

    /**
     * Instantiates a new Dsu.
     *
     * @param capacity the vertices amount
     */
    public DSU(int capacity) {
        componentNumber = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            makeSet(i);
        }
    }

    /**
     * Enters into the system new vertex, creates the set with root = vertex.
     *
     * @param vertex the new vertex
     */
    private void makeSet(int vertex) {
        componentNumber[vertex] = vertex;
    }

    /**
     * Finds root of the tree contains the vertex.
     *
     * @param vertex the new vertex
     * @return root
     */
    private int findRoot(int vertex) {
        return componentNumber[vertex] == vertex
                ? vertex
                : (componentNumber[vertex] = findRoot(componentNumber[vertex]));
    }

    /**
     * Unites trees which contains firstVertex, secondVertex.
     * New number components = to smaller number components from these two.
     *
     * Vertex - 1, because vertices of the graph are numbered from 1 to n.
     *      But array initialize from 0 to n - 1.
     *
     * @param firstVertex  the vertex of the first tree
     * @param secondVertex the vertex of the second tree
     * @return whether to contain two мукешсуы in one component
     */
    public boolean unite(int firstVertex, int secondVertex) {
        firstVertex = firstVertex - 1;
        secondVertex = secondVertex - 1;
        int rootFirstVertex = findRoot(firstVertex);
        int rootSecondVertex = findRoot(secondVertex);
        if (rootFirstVertex < rootSecondVertex) {
            componentNumber[rootFirstVertex] = rootSecondVertex;
        } else if (rootFirstVertex > rootSecondVertex) {
            componentNumber[rootFirstVertex] = rootSecondVertex;
        } else {
            return false;
        }
        return true;
    }
}

