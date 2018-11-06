package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.CreatorDefaultGraph;
import by.bsu.likhanova.algorithm.Kruskal;
import by.bsu.likhanova.algorithm.Prim;
import by.bsu.likhanova.entity.UndirectedGraph;


import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu(UndirectedGraph graph) {

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
                    "9)Prim algorithm\n" +
                    "0)If you finished");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(
                            "At addition of new edge " +
                                    " it is necessary to specify three numbers: " +
                                    "numbers of two tops and edge weight.\n" +
                            "The value of the edge weight is an integer and more then 0.\n" +
                            "Numbering of vertices has to begin with 1 " +
                                    "and at addition of new: previous number + 1.\n");
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
                    System.out.println("graph is koenigsber bridges");
                    graph = CreatorDefaultGraph.createDefaultGraph();
                    break;
                case 8:
                    if (graph != null) {
                    System.out.println(Kruskal.searchMinimalSkeletonGraph(graph));
                    } else {
                        System.out.println("Entered graph.");
                    }
                    break;
                case 9:
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
