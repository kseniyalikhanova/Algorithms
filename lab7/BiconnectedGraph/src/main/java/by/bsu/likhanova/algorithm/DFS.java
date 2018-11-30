package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.GraphWithAdjacencyList;
import by.bsu.likhanova.wrapper.ChangedBoolean;
import by.bsu.likhanova.wrapper.ChangedInteger;

import java.util.*;

import static java.lang.Integer.min;

public class DFS {

    private GraphWithAdjacencyList graph;
    private Map<Integer, ChangedInteger> height;
    private Map<Integer, ChangedInteger> f;
    private Map<Integer, ChangedBoolean> usedVertex;
    private List<Integer> cutPoints;
    private List<Integer> additionalEdges;

    public DFS(GraphWithAdjacencyList newGraph) {
        this.graph = newGraph;
        this.cutPoints = new LinkedList<>();
        this.additionalEdges = new ArrayList<>();

        this.height = new HashMap<>();
        this.f = new HashMap<>();
        this.usedVertex = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.getAdjacencyList().entrySet()) {
            height.put(entry.getKey(), new ChangedInteger());
            f.put(entry.getKey(), new ChangedInteger());
            usedVertex.put(entry.getKey(), new ChangedBoolean());
        }

    }

    public List<Integer> getCutPoints() {
        return cutPoints;
    }

    public void clearCutPoints() {
        cutPoints.clear();
    }

    //f[vertex] - min height from vertexHeight and childHeight
    public void searchCutPoints(Integer vertex, Integer parent, int vertexHeight) {
        if (vertex - 1 != 0) {
            height.get(vertex).value = vertexHeight++;
        }
        f.get(vertex).value = height.get(vertex).value;
        usedVertex.get(vertex).value = true;
        int children = 0;
        for (Integer child : graph.getAdjacencyList().get(vertex)) {
            if (child.equals(parent)) {
                continue;
            }
            if (!usedVertex.get(child).value) {
                searchCutPoints(child, vertex, vertexHeight);
                f.get(vertex).value = min(f.get(vertex).value, f.get(child).value);

                if (f.get(child).value >= height.get(vertex).value && parent != null) {
                    if (!cutPoints.contains(vertex)) {
                        cutPoints.add(vertex);
                    }
                    additionalEdges.add(child);
                    additionalEdges.add(parent);
                }

                ++children;
            } else
                f.get(vertex).value = min(f.get(vertex).value, height.get(child).value);
        }
        if (parent == null && children > 1) {
            cutPoints.add(vertex);
            int i = 0;
            for (Integer child : graph.getAdjacencyList().get(vertex)) {
                additionalEdges.add(child);
                if (i > 0 && i < graph.getAdjacencyList().get(vertex).size() - 1) {
                    additionalEdges.add(child);
                }
                ++i;
            }
        }
    }

    public GraphWithAdjacencyList completeToBiconnectedGraph() {
        for (int i = 0; i < additionalEdges.size(); i++) {
            graph.addEdge(additionalEdges.get(i), additionalEdges.get(++i));
        }
        return graph;
    }
}
