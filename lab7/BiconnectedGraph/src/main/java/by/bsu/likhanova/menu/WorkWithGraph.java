package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.CreatorDefaultGraph;
import by.bsu.likhanova.algorithm.DFS;
import by.bsu.likhanova.entity.GraphWithAdjacencyList;

import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu(GraphWithAdjacencyList graph) {
        String menu = "1)Print Instruction\n" +
                      "2)Add vertex\n" +
                      "3)Add edge\n" +
                      "4)Delete vertex\n" +
                      "5)Delete edge\n" +
                      "6)Print graph\n" +
                      "7)Clear the graph\n" +
                      "8)Default graph\n" +
                      "9)Define the graph is biconnected\n" +
                      "0)If you finished";
        boolean isOpenedMenu = true;
        while (isOpenedMenu) {
            switch (enterNumber(menu)) {
                case 1:
                    System.out.println(
                            "When creating a graph, vertices are added first and then edges. " +
                                    "Since if the selected vertices do not exist, " +
                                    "then the edge will not be created.\n" +
                            "Numbering of vertices has to begin with 1" +
                                    "and at addition of new: previous number + 1.");
                    break;
                case 2:
                    graph.addVertex(
                            enterNumber("Enter number of the new vertex (int): "));
                    break;
                case 3:
                    graph.addEdge(
                            enterNumber("Enter numbers of first vertex for connected (int):"),
                            enterNumber("Enter numbers of second vertex for connected (int):")
                    );
                    break;
                case 4:
                    graph.removeVertex(
                            enterNumber("Enter number of the vertex for removal (int): "));
                    break;
                case 5:
                    graph.removeEdge(
                            enterNumber("Enter numbers of first vertex for removal (int):"),
                            enterNumber("Enter numbers of second vertex for removal (int):")
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
                    CreatorDefaultGraph.createDefaultGraph(graph);
                    break;
                case 9:
                    if (graph != null) {
                        DFS dfs = new DFS(graph);
                        dfs.completeToBiconnected(graph.getAdjacencyList().keySet().iterator().next(),
                                null, 0, new int[graph.getAdjacencyList().keySet().size()],
                                new int[graph.getAdjacencyList().keySet().size()],
                                new boolean[graph.getAdjacencyList().keySet().size()]);
                        if (dfs.getCutPoints().isEmpty()) {
                            System.out.println("This graph is biconnected.");
                        } else {
                            System.out.println("Cut points = " + dfs.getCutPoints());
                            System.out.println("The graph is completed to the biconnected.");
                            System.out.println(graph);
                        }
                        dfs.clearCutPoints();
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
