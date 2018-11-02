package by.bsu.likhanova.menu;

import by.bsu.likhanova.action.CreatorDefaultGraph;
import by.bsu.likhanova.algorithm.EulerCycle;
import by.bsu.likhanova.entity.UndirectedGraph;
import by.bsu.likhanova.entity.Vertex;

import java.util.Scanner;

public class WorkWithGraph {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu(UndirectedGraph graph) {

        boolean isOpenedMenu = true;
        while (isOpenedMenu ) {
            System.out.println(
                    "1)Print Instruction\n" +
                    "2)Add vertex\n" +
                    "3)Add edge\n" +
                    "4)Delete vertex\n" +
                    "5)Delete edge\n" +
                    "6)Print graph\n" +
                    "7)Clear the graph\n" +
                    "8)Default graph\n" +
                    "9)Find Euler path\n" +
                    "0)If you finished");
            switch(scanner.nextInt()){
                case 1:
                    System.out.println(
                            "When creating a graph, vertices are added first and then edges. " +
                            "Since if the selected vertices do not exist, " +
                            "then the edge will not be created.\n" +
                            "The value of the vertex is an integer.");
                    break;
                case 2:
                    graph.addVertex(new Vertex(
                            enterNumber("Enter number of the new vertex (int): ")));
                    break;
                case 3:
                    graph.addEdge(
                            new Vertex(
                                enterNumber("Enter numbers of first vertex for connected (int):")),
                            new Vertex(
                                enterNumber("Enter numbers of second vertex for connected (int):")
                            ));
                    break;
                case 4:
                    graph.removeVertex(new Vertex(
                            enterNumber("Enter number of the vertex for removal (int): ")));
                    break;
                case 5:
                    graph.removeEdge(
                            new Vertex(
                                    enterNumber("Enter numbers of first vertex for removal (int):")),
                            new Vertex(
                                    enterNumber("Enter numbers of second vertex for removal (int):")
                            ));
                    break;
                case 6:
                    System.out.println(graph);
                    break;
                case 7:
                    if (graph != null){
                        graph.clear();
                    }
                    break;
                case 8:
                    System.out.println("graph is koenigsber bridges");
                    graph = CreatorDefaultGraph.createDefaultGraph();
                    break;
                case 9:
                    EulerCycle eulerCycle = new EulerCycle();
                    if (eulerCycle.isHasEulerCycle(graph)){
                        System.out.println(eulerCycle.findEulerPath(graph));
                    } else {
                        System.out.println("This graph hasn't euler cycle");
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

    private static int enterNumber(final String msg){
        System.out.println(msg);
        while (!scanner.hasNextInt()){
            System.out.println(msg);
        }
        return scanner.nextInt();
    }
}
