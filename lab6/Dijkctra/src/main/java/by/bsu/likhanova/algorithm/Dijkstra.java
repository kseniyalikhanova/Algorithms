package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.AdjacentVertex;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.min;
import static java.util.Arrays.fill;

public class Dijkstra {

    private static final int INFINITY = Integer.MAX_VALUE / 2;
    private List<Integer> shortestRoute;
    private int shortestRouteLength;

    public Dijkstra() {
        shortestRoute = new LinkedList<>();
    }

    public void searchShortestRoute(final GraphWithAdjacencyList graph,
                                    final int startVertex,
                                    final int endVertex){
        int verticesAmount = graph.getAdjacencyList().size();
        boolean[] used = new boolean[verticesAmount];
        int[] prev = new int[verticesAmount];
        int[] distance = new int[verticesAmount];

        fill(prev, -1);
        fill(distance, INFINITY);
        distance[startVertex - 1] = 0;

        while (true) {
            int currentVertex = -1;
            // выбираем самую близкую непомеченную вершину
            for (Integer vertex : graph.getAdjacencyList().keySet()) {
                if (!used[vertex - 1] && distance[vertex - 1] < INFINITY
                        && (currentVertex == -1
                        || distance[currentVertex - 1] > distance[vertex - 1])) {
                    currentVertex = vertex;
                }
            }
            if (currentVertex == -1) {
                break;
            }
            used[currentVertex - 1] = true;
            for (AdjacentVertex vertex : graph.getAdjacencyList().get(currentVertex)) {
                if(!used[vertex.getVertex() - 1]){
                    int initialDistance = distance[vertex.getVertex() - 1];
                    distance[vertex.getVertex() - 1] = min(distance[vertex.getVertex() - 1],
                                                       distance[currentVertex - 1] + vertex.getWeight());
                    if (initialDistance != distance[vertex.getVertex() - 1]){
                        prev[vertex.getVertex() - 1] = currentVertex;
                    }
                }
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int vertex = endVertex; vertex != -1; vertex = prev[vertex - 1]) {
                stack.push(vertex);
        }
        while (!stack.isEmpty()){
            shortestRoute.add(stack.pop());
        }

        shortestRouteLength = distance[endVertex - 1];
    }

    public List<Integer> getShortestRoute() {
        return shortestRoute;
    }

    public int getShortestRouteLength() {
        return shortestRouteLength;
    }
}
