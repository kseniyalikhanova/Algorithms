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

    private GraphWithAdjacencyList graph;
    private int startVertex;
    private boolean[] used;
    private int[] prev;
    private int[] distance;
    private List<Integer> shortestRoute;
    private int shortestRouteLength;

    public Dijkstra(final GraphWithAdjacencyList newGraph, final int newStartVertex) {
        this.graph = newGraph;
        this.startVertex = newStartVertex;
        used = new boolean[graph.getAdjacencyList().size()];
        prev = new int[graph.getAdjacencyList().size()];
        distance = new int[graph.getAdjacencyList().size()];
        shortestRoute = new LinkedList<>();
    }

    public void perform(){
        fill(prev, -1);
        fill(distance, INFINITY);
        distance[startVertex - 1] = 0;

        while (true) {
            int currentVertex = -1;
            // Chooses the closest not used top
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

            // Remark vertices
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
    }

    public int getStartVertex() {
        return startVertex;
    }

    public void searchShortestRoute(final int endVertex){
        if (!shortestRoute.isEmpty()) {
            shortestRoute.clear();
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
