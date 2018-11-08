package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.AdjacentVertex;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.List;
import java.util.Set;

public class SearchingMinEdge {
    public static Integer[] searchMinEdge(final GraphWithAdjacencyList graph,
                                               final List<Integer> unusedVertices,
                                               final Set<Integer> potentialVertices){
        // [0] - unusedVertex, [1] - vertex from potentialVertices
        Integer[] minEdge = new Integer[2];
        AdjacentVertex vertexWithMinEdge = new AdjacentVertex();
        vertexWithMinEdge.setWeight(Integer.MAX_VALUE);
        AdjacentVertex potentialMinEdge;
        for (Integer vertex: unusedVertices) {
            potentialMinEdge = searchVertexWithMinEdge(graph, vertex, potentialVertices);
            if (potentialMinEdge.getVertex() != -1
                && potentialMinEdge.compareTo(vertexWithMinEdge) < 0){
                vertexWithMinEdge = potentialMinEdge;
                minEdge[0] = vertex;
                minEdge[1] = vertexWithMinEdge.getVertex();
            }
        }
        return minEdge;
    }

    private static AdjacentVertex searchVertexWithMinEdge(final GraphWithAdjacencyList graph,
                                                          final Integer vertex,
                                                          final Set<Integer> potentialVertices) {
        AdjacentVertex minEdge = new AdjacentVertex();
        for (AdjacentVertex edge : graph.getAdjacencyList().get(vertex)) {
            if (potentialVertices.contains(edge.getVertex())) {
                minEdge = edge;
                break;
            }
        }
        return minEdge;
    }
}
