package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.AdjacentVertex;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.min;
import static java.util.Arrays.fill;

public class Dijkstra {

    private static final int INFINITY = Integer.MAX_VALUE / 2;

    public static GraphWithAdjacencyList searchShortestRoute(final GraphWithAdjacencyList graph,
                                                             final int startVertex,
                                                             final int endVertex){
        int verticesAmount = graph.getAdjacencyList().size();
        boolean[] used = new boolean [verticesAmount];
        int[] prev = new int [verticesAmount];
        int[] distance = new int [verticesAmount];

        fill(prev, -1);
        fill(distance, INFINITY);
        distance[startVertex] = 0;

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
                    distance[vertex.getVertex() - 1] = min(distance[vertex.getVertex() - 1],
                                                       distance[currentVertex - 1] + vertex.getWeight());
                    prev[vertex.getVertex() - 1] = currentVertex;
                }
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int vertex = endVertex; vertex != -1; vertex = prev[vertex]) {
                stack.push(vertex);
        }
        GraphWithAdjacencyList shortestRoute = new GraphWithAdjacencyList();
        for (int i = 0; i < stack.size(); i++){
            shortestRoute.addVertex(stack.pop());
        }

        Integer[] keyArray = (Integer[])shortestRoute.getAdjacencyList().keySet().toArray();
        for (int i = 0; i < keyArray.length - 1; i++) {
            shortestRoute.addEdge(keyArray[i],
                                  graph.searchEdge(keyArray[i], keyArray[i + 1]));
        }

        return shortestRoute;
    }
}
