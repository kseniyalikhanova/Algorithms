package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.CreatorDefaultGraph;
import by.bsu.likhanova.algorithm.Kruskal;
import by.bsu.likhanova.algorithm.Prim;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;
import by.bsu.likhanova.entity.GraphWithEdgesList;
import by.bsu.likhanova.entity.UndirectedGraph;


import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);

    private static UndirectedGraph chooseGraphType() {
        boolean isOpened = true;
        while (isOpened) {
            System.out.println("Enter 1 if you would like to use Kruskal algorithm.\n " +
                               "Enter 2 if you would like to use Prim algorithm.");
            switch (scanner.nextInt()) {
                case 1:
                    return new GraphWithEdgesList();
                case 2:
                    return new GraphWithAdjacencyList();
                default:
                    System.out.println("Enter 1 or 2.");
                    break;
            }
        }
        return new UndirectedGraph();
    }

    public static void printMenu() {
        UndirectedGraph graph = chooseGraphType();
        if (graph instanceof GraphWithEdgesList){
            menuForKruskal((GraphWithEdgesList)graph);
        } else if (graph instanceof GraphWithAdjacencyList){
            menuForPrim((GraphWithAdjacencyList) graph);
        } else {
            System.out.println("Not such graph");
        }
        scanner.close();
    }

    private static void menuForKruskal(GraphWithEdgesList graph){
        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            System.out.println(
                    "1)Print Instruction\n" +
                    "2)Add edge\n" +
                    "3)Delete edge\n" +
                    "4)Print vertices of graph\n" +
                    "5)Print graph\n" +
                    "6)Clear the graph\n" +
                    "7)Default graph\n" +
                    "8)Kraskal algorithm\n" +
                    "0)If you finished");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(
                            "At addition of new edge " +
                                    " it is necessary to specify three numbers: " +
                                    "numbers of two tops and edge weight.\n" +
                            "The value of the edge weight is an integer and more then 0.\n" +
                            "Numbering of vertices has to begin with 1 " +
                                    "and at addition of new: previous number + 1.");
                    break;
                case 2:
                    graph.addEdge(
                            enterNumber("Enter first vertex number of edge(int): "),
                            enterNumber("Enter second vertex number of edge(int): "),
                            enterNumber("Enter edge weight (int) > 0: ")
                    );
                    break;
                case 3:
                    graph.removeEdge(
                            enterNumber("Enter first vertex number of edge(int): "),
                            enterNumber("Enter second vertex number of edge(int): "),
                            enterNumber("Enter edge weight (int) > 0: ")
                    );
                    break;
                case 4:
                    System.out.println(graph.getVertices()  );
                    break;
                case 5:
                    System.out.println(graph);
                    break;
                case 6:
                    if (graph != null) {
                        graph.clear();
                    }
                    break;
                case 7:
                    System.out.println("Default graph");
                    graph = CreatorDefaultGraph.createDefaultGraphWithEdgesList();
                   // graph = CreatorDefaultGraph.createDefaultGraphWithAdjacencyList();
                    break;
                case 8:
                    if (graph != null) {
                    System.out.println(Kruskal.searchMinimalSkeletonGraph(graph));
                    } else {
                        System.out.println("Entered graph.");
                    }
                    break;
                /*case 9:
                    if (graph != null) {
                        System.out.println(Prim.searchMinimalSkeletonGraph(graph));
                    } else {
                        System.out.println("Entered graph.");
                    }
                    break;*/
                case 0:
                    isOpenedMenu = false;
                    break;
                default:
                    System.out.println("Choose number from the menu");
                    break;
            }
        }
    }

    private static void menuForPrim(GraphWithAdjacencyList graph){
        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            System.out.println(
                    "1)Print Instruction\n" +
                    "2)Add vertex\n" +
                    "3)Add edge\n" +
                    "4)Delete vertex\n" +
                    "5)Delete edge\n" +
                    "6)Print vertices of graph\n" +
                    "7)Print graph\n" +
                    "8)Clear the graph\n" +
                    "9)Default graph\n" +
                    "10)Prim algorithm\n" +
                    "0)If you finished");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(
                            "When creating a graph, vertices are added first and then edges. " +
                                    "Since if the selected vertices do not exist, " +
                                    "then the edge will not be created.\n" +
                            "At addition of new edge " +
                                    " it is necessary to specify three numbers: " +
                                    "numbers of two tops and edge weight.\n" +
                            "The value of the edge weight is an integer and more then 0.\n" +
                            "Numbering of vertices has to begin with 1" +
                                    "and at addition of new: previous number + 1.");
                    break;
                case 2:
                    graph.addVertex(
                            enterNumber("Enter number of the new vertex (int): "));
                    break;
                case 3:
                    graph.addEdge(
                            enterNumber("Enter first vertex number of edge(int): "),
                            enterNumber("Enter second vertex number of edge(int): "),
                            enterNumber("Enter edge weight (int) > 0: ")
                    );
                    break;
                case 4:
                    graph.removeVertex(
                            enterNumber("Enter number of the vertex for removal (int): "));
                    break;
                case 5:
                    graph.removeEdge(
                            enterNumber("Enter first vertex number of edge(int): "),
                            enterNumber("Enter second vertex number of edge(int): ")
                    );
                    break;
                case 6:
                    System.out.println(graph.getAdjacencyList().keySet());
                    break;
                case 7:
                    System.out.println(graph);
                    break;
                case 8:
                    if (graph != null) {
                        graph.clear();
                    }
                    break;
                case 9:
                    System.out.println("Default graph");
                    graph = CreatorDefaultGraph.createDefaultGraphWithAdjacencyList();
                    break;
                case 10:
                    if (graph != null) {
                        System.out.println(Prim.searchMinimalSkeletonGraph(graph));
                    } else {
                        System.out.println("Entered graph.");
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
    }

    private static int enterNumber(final String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println(msg);
        }
        return scanner.nextInt();
    }
}
