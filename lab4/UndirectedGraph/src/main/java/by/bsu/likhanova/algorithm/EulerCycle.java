package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.List;

public class EulerCycle {
    public boolean isHasEulerCycle(final UndirectedGraph graph) {
        BFS bfs = new BFS(graph);
        List<Integer> verticesInComponent;
        boolean isHasEulerCycle = true;

        for (List<Integer[]> vertices : graph.getAdjacencyList().values()) {
            if (vertices.size() % 2 != 0) {
                isHasEulerCycle = false;
                break;
            }
        }
        if(isHasEulerCycle) {
            verticesInComponent = bfs.bfs(graph.getAdjacencyList().values().iterator().next().get(0)[0]);
            for(Integer vertices : graph.getAdjacencyList().keySet()) {
                if (!verticesInComponent.contains(vertices)
                        && graph.getAdjacencyList().get(vertices).isEmpty()){
                    isHasEulerCycle = false;
                    break;
                }
            }
        }
        return isHasEulerCycle;
    }

    public ArrayDeque<Integer> findEulerPath(final UndirectedGraph graph) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Integer topVertex;
        Integer nextVertex;

        stack.push(graph.getAdjacencyList().keySet().iterator().next());
        while (!stack.isEmpty()) {
            topVertex = stack.peek();
            nextVertex = null;

            for (Integer[] vertex : graph.getAdjacencyList().get(topVertex)) {
                if (vertex[1] == 0) {
                    nextVertex = vertex[0];
                    graph.markEdge(topVertex, vertex[0]);
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
