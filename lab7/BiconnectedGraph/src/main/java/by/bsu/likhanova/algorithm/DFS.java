package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.min;

public class DFS {

    private List<Integer> cutPoints;
    private GraphWithAdjacencyList graph;

    public DFS(GraphWithAdjacencyList newGraph) {
        cutPoints = new LinkedList<>();
        graph = newGraph;
    }

    public List<Integer> getCutPoints() {
        return cutPoints;
    }

    public void clearCutPoints() {
        cutPoints.clear();
    }

    //f[vertex] - min height from vertexHeight and childHeight
    public void completeToBiconnected(Integer vertex, Integer parent,
                                      int vertexHeight, int[] height,
                                      int[] f, boolean[] visited) {
        if (vertex - 1 != 0) {
            height[vertex - 1] = vertexHeight++;
        }
        f[vertex - 1] = height[vertex - 1];
        visited[vertex - 1] = true;
        int children = 0;
        /*Iterator graphIterator = graph.getAdjacencyList().entrySet().iterator();
        List<Integer> vertexChildren;
        while (graphIterator.hasNext())
        {
            vertexChildren = (List<Integer>)graphIterator.next();
            graphIterator.remove(child);
        }*/
        for (Integer child : graph.getAdjacencyList().get(vertex)) {
            if (child.equals(parent)) {
                continue;
            }
            if (!visited[child - 1]) {
                completeToBiconnected(child, vertex, vertexHeight, height, f, visited);
                f[vertex - 1] = min(f[vertex - 1], f[child - 1]);
                if (f[child - 1] >= height[vertex - 1] && parent != null) {
                    cutPoints.add(vertex);
                    graph.addEdge(child, parent);
                    completeToBiconnected(vertex, parent, vertexHeight, height, f, visited);
                }
                ++children;
            } else
                f[vertex - 1] = min(f[vertex - 1], height[child - 1]);
        }
        if (parent == null && children > 1) {
            cutPoints.add(vertex);
        }
    }
}
