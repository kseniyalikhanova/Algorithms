package by.bsu.likhanova.algorithm;

import by.bsu.likhanova.wrapper.ChangedBoolean;
import by.bsu.likhanova.entity.UndirectedGraph;
import by.bsu.likhanova.wrapper.ChangedInteger;

import java.util.*;

public class BFS {
    private Map<Integer, ChangedBoolean> usedVertex;
    // -1 - no painted, 0 - even, 1 - odd
    private Map<Integer, ChangedInteger> paintedVertex;
    private Map<Integer, List<Integer[]>> adjacencyList;

    public BFS(final UndirectedGraph graph){
        usedVertex = new HashMap<>();
        adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Integer, List<Integer[]>> entry : adjacencyList.entrySet()) {
            usedVertex.put(entry.getKey(), new ChangedBoolean());
            paintedVertex.put(entry.getKey(), new ChangedInteger());
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

    public List<List<Integer>> bfsColor(final Integer startVertex) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //shares - доли
        List<List<Integer>> shares = new LinkedList<>();
        List<Integer> verticesShare1 = new LinkedList<>();
        List<Integer> verticesShare2 = new LinkedList<>();
        shares.add(verticesShare1);
        shares.add(verticesShare2);

        Integer topVertex;
        paintedVertex.get(startVertex).value = 0;
        queue.add(startVertex);
        verticesShare1.add(startVertex);
        while (!queue.isEmpty()){
            topVertex = queue.poll();
            for (Integer[] vertex : adjacencyList.get(topVertex)) {
                if(paintedVertex.get(vertex[0]).value == -1){
                    if (paintedVertex.get(topVertex).value == 0) {
                        paintedVertex.get(vertex[0]).value = 1;
                        verticesShare1.add(vertex[0]);
                    } else {
                        paintedVertex.get(vertex[0]).value = 0;
                        verticesShare2.add(vertex[0]);
                    }
                    queue.add(vertex[0]);
                } else if (paintedVertex.get(vertex).value == paintedVertex.get(topVertex).value){
                    return null;
                }
            }
        }
        return shares;
    }

    public List<List<Integer>> isBipartiteGraph(){
            List<List<Integer>> shares = bfsColor(adjacencyList.keySet().iterator().next());
        if (!isUnilaterallyConnectedGraph() || shares == null){
            return null;
        }
        return shares;
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

    public boolean isUnilaterallyConnectedGraph(){
        boolean isFlag = true;
        List<Integer> verticesInComponent =
                bfs(adjacencyList.values().iterator().next().get(0)[0]);
        for(Integer vertices : adjacencyList.keySet()) {
            if (!verticesInComponent.contains(vertices)){
                isFlag = false;
                break;
            }
        }
        return isFlag;
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
