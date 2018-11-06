package by.bsu.likhanova.runner;

import by.bsu.likhanova.entity.UndirectedGraph;
import by.bsu.likhanova.menu.WorkWithGraph;

public class UdirectedGraphRunner {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        WorkWithGraph.printMenu(graph);
    }
}
