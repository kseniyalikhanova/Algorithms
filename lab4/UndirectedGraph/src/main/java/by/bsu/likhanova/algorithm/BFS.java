package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.entity.ChangedBoolean;
import by.bsu.likhanova.entity.UndirectedGraph;

import java.util.*;

public class BFS {
    private Map<Integer, ChangedBoolean> usedVertex;
    private Map<Integer, List<Integer[]>> adjacencyList;

    public BFS(final UndirectedGraph graph){
        usedVertex = new HashMap<>();
        adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Integer, List<Integer[]>> entry : adjacencyList.entrySet()) {
            usedVertex.put(entry.getKey(), new ChangedBoolean());
        }
    }

    public List<Integer> bfs(final Integer startVertex) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> vertices = new LinkedList<>();
        Integer topVertex;
        usedVertex.get(startVertex).bool = true;
        queue.add(startVertex);
        vertices.add(startVertex);
        while (!queue.isEmpty()){
            topVertex = queue.poll();
            for (Integer[] vertex : adjacencyList.get(topVertex)) {
                if(!usedVertex.get(vertex[0]).bool){
                    usedVertex.get(vertex[0]).bool = true;
                    queue.add(vertex[0]);
                    vertices.add(vertex[0]);
                }
            }
        }
        return vertices;
    }

    public Map<Integer, List<Integer>> findConnectivityComponents() {
        Map<Integer, List<Integer>> components = new HashMap<>();
        int componentNumber = 0;
        for (Integer vertex : adjacencyList.keySet()) {
            if(!usedVertex.get(vertex).bool){
                components.put(++componentNumber, bfs(vertex));
            }
        }
        return components;
    }

    public String printComponents(Map<Integer, List<Integer>> components) {
        String resultString = "";
        if (adjacencyList.isEmpty()) {
            resultString += "Graph is empty.";
        } else {
            resultString += "Components{\n";
            for (Map.Entry<Integer, List<Integer>> entry : components.entrySet()) {
                resultString += "[" + entry.getKey() + " component : ";
                for (Integer vertex : entry.getValue()) {
                    resultString += vertex + " = {";
                    for (Integer[] vertexNumber : adjacencyList.get(vertex)) {
                        resultString += vertexNumber[0] + ", ";
                    }
                    resultString += "}, ";
                }
                resultString += "],\n";
            }
            resultString += "}";
        }
        return resultString;
    }
}
