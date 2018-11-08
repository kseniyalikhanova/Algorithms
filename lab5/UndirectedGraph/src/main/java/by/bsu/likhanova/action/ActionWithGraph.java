package by.bsu.likhanova.action;

import by.bsu.likhanova.entity.AdjacentVertex;
import by.bsu.likhanova.entity.Edge;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;
import by.bsu.likhanova.entity.GraphWithEdgesList;

import java.util.Map;
import java.util.TreeSet;

public class ActionWithGraph {
    public static GraphWithEdgesList searchEdgesAssociation(GraphWithEdgesList graphWithEdgesList,
                                                            GraphWithAdjacencyList graphWithAdjacencyList){
        GraphWithEdgesList resultGraph = new GraphWithEdgesList();
        resultGraph.setEdges(graphWithEdgesList.getEdges());
        for (Edge edge :
                transformAdjacencyListToEdgesList(graphWithAdjacencyList).getEdges()) {
            resultGraph.addEdge(edge);
        }
        return resultGraph;
    }

    public static GraphWithEdgesList transformAdjacencyListToEdgesList(GraphWithAdjacencyList graph){
        GraphWithEdgesList resultGraph = new GraphWithEdgesList();
        for (Map.Entry<Integer, TreeSet<AdjacentVertex>> entry
                : graph.getAdjacencyList().entrySet()) {
            for (AdjacentVertex vertex : entry.getValue()) {
                resultGraph.addEdge(entry.getKey(), vertex.getVertex(), vertex.getWeight());
            }
        }
        return resultGraph;
    }
}
