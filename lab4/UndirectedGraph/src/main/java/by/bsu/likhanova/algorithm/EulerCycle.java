package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.UndirectedGraph;
import by.bsu.likhanova.entity.Vertex;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class EulerCycle {
    public boolean isHasEulerCycle(final UndirectedGraph graph) {
        boolean isHasEulerCycle = true;
        for (LinkedList<Vertex> vertices : graph.getAdjacencyList().values()) {
            if (vertices.size() % 2 != 0) {
                isHasEulerCycle = false;
                break;
            }
        }
        // Added on connected graph
        return isHasEulerCycle;
    }

    public ArrayDeque<Vertex> findEulerPath(final UndirectedGraph graph) {
        ArrayDeque<Vertex> stack = new ArrayDeque<>();
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        Vertex topVertex;
        Vertex nextVertex;

        stack.push(graph.getAdjacencyList().keySet().iterator().next());
        while (!stack.isEmpty()) {
            topVertex = stack.peek();
            nextVertex = null;

            for (Vertex vertex : graph.getAdjacencyList().get(topVertex)) {
                if (!vertex.isMarked()) {
                    nextVertex = vertex;
                    graph.markEdge(topVertex, vertex);
                    break;
                }
            }

            if (nextVertex != null) {
                stack.push(nextVertex);
            } else {
                queue.add(stack.pop());
            }
        }
        return queue;
    }
}
