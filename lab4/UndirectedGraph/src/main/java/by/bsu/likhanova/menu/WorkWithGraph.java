package by.bsu.likhanova.menu;

import by.bsu.likhanova.entity.UndirectedGraph;

import java.util.Scanner;

public class WorkWithGraph {
    public static void printMenu(UndirectedGraph graph) {
        Scanner scanner = new Scanner(System.in);
        boolean isOpenedMenu = true;
        while (isOpenedMenu ) {
            System.out.println(
                    "1)Print graph\n" +
                    "2)Add vertex\n" +
                    "3)Add edge\n" +
                    "4)Delete vertex\n" +
                    "5)Delete edge\n" +
                    "6)Example\n" +
                    "7)Build eulerian cycle\n" +
                    "0)If you finished");
            switch(scanner.nextInt()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    isOpenedMenu = false;
                    break;
                default:
                    break;
            }
        }
    }
}
