package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.Searching;
import by.bsu.likhanova.algorithm.Floyd;
import by.bsu.likhanova.entity.GraphWithAdjacencyMatrix;

import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);
    private static GraphWithAdjacencyMatrix graph;

    public static void printMenu() {

        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            System.out.println(
                    "1)Print Instruction\n" +
                            "2)Create graph\n" +
                            "3)Add edge\n" +
                            "4)Delete edge\n" +
                            "5)Print graph\n" +
                            "6)Clear the graph\n" +
                            "7)Floyd's algorithm\n" +
                            "8)Optimal location of the fire station\n" +
                            "0)If you finished"
            );
            switch (enterNumber("Choose number from the menu")) {
                case 1:
                    System.out.println(
                            "At creation a graph, it is necessary to set the size of the graph.\n" +
                                    "If the selected vertices do not exist, " +
                                    "then the edge will not be created.\n" +
                                    "At addition of new edge " +
                                    " it is necessary to specify three numbers: " +
                                    "numbers of two tops and edge weight.\n" +
                                    "The value of the edge weight is an integer and more then 0.\n"
                    );
                    break;
                case 2:
                    int size = -1;
                    while (size <= 0) {
                        size = enterNumber("Enter amount of vertex in graph (int) > 0: ");
                    }
                    graph = new GraphWithAdjacencyMatrix(size);
                    break;
                case 3:
                    if (graph != null) {
                        graph.addEdge(
                                enterNumber("Enter first vertex number of edge(int): ") - 1,
                                enterNumber("Enter second vertex number of edge(int): ") - 1,
                                enterNumber("Enter edge weight (int) > 0: ")
                        );
                    } else {
                        System.out.println("Create a graph.");
                    }
                    break;
                case 4:
                    if (graph != null) {
                        graph.removeEdge(
                                enterNumber("Enter first vertex number of edge(int): ") - 1,
                                enterNumber("Enter second vertex number of edge(int): ") - 1
                        );
                    } else {
                        System.out.println("Create a graph.");
                    }
                    break;
                case 5:
                    if (graph != null) {
                        System.out.println(graph);
                    } else {
                        System.out.println("Create a graph.");
                    }
                    break;
                case 6:
                    if (graph != null) {
                        graph.clear();
                    }
                    break;
                case 7:
                    if (graph != null) {
                        GraphWithAdjacencyMatrix floyd = Floyd.perform(graph);
                        System.out.println(floyd);
                    } else {
                        System.out.println("Create a graph.");
                    }
                    break;
                case 8:
                    if (graph != null) {
                        GraphWithAdjacencyMatrix floydGraph = Floyd.perform(graph);
                        int optimalLocation = Searching.searchOptimalLocationOfFireStation(floydGraph);
                        System.out.println("Crossroads at number " + optimalLocation
                                + "is optimal location of the fire station");
                    } else {
                        System.out.println("Create a graph.");
                    }
                    break;
                case 0:
                    isOpenedMenu = false;
                    break;
                default:
                    System.out.println("Choose number from the menu");
                    break;
            }
        }
        scanner.close();
    }

    private static int enterNumber(final String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println(msg);
        }
        return scanner.nextInt();
    }
}
