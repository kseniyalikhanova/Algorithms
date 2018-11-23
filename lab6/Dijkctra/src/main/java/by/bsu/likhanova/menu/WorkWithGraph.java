package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.CreatorDefaultGraph;
import by.bsu.likhanova.algorithm.Dijkstra;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.List;
import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu(GraphWithAdjacencyList graph) {

        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            System.out.println(
                    "1)Print Instruction\n" +
                    "2)Add vertex\n" +
                    "3)Add edge\n" +
                    "4)Delete vertex\n" +
                    "5)Delete edge\n" +
                    "6)Print graph\n" +
                    "7)Clear the graph\n" +
                    "8)Default graph\n" +
                    "9)Search shortest route\n" +
                    "0)If you finished");
            switch (enterNumber("Choose number from the menu")) {
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
                    System.out.println(graph);
                    break;
                case 7:
                    if (graph != null) {
                        graph.clear();
                    }
                    break;
                case 8:
                    System.out.println("Default graph");
                    graph = CreatorDefaultGraph.createDefaultGraph();
                    break;
                case 9:
                    int startVertex = enterNumber("Enter the start vertex number for dijkstra(int): ");
                    Dijkstra dijkstra = new Dijkstra(graph, startVertex);
                    dijkstra.perform();
                    chooseRoute(dijkstra);
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

    private static void chooseRoute(final Dijkstra dijkstra) {
        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            int number = enterNumber("\nEnter the end vertex number for dijkstra(int)\n" +
                                          "0) If you finished.");
            switch (number) {
                case 0:
                    isOpenedMenu = false;
                    break;
                default:
                    dijkstra.searchShortestRoute(number);
                    System.out.println("Shortest route from " + dijkstra.getStartVertex() + " vertex to "
                                        + number + " vertex =" + dijkstra.getShortestRoute());
                    System.out.println("Length of shortest route = " + dijkstra.getShortestRouteLength());
                    break;
            }
        }
    }
}
