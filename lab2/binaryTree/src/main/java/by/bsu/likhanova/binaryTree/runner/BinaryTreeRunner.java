package by.bsu.likhanova.binaryTree.runner;

import by.bsu.likhanova.binaryTree.tree.BinaryTree;
import by.bsu.likhanova.binaryTree.tree.BinaryTreePrinter;

import java.io.*;

public class BinaryTreeRunner {
    public static void main(String[] args) throws IOException {
        int[] array = {10,5,11,9,8,17,15,14,0,20,16,35};
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }
        System.out.println(tree.containsNode(17));

        BinaryTreePrinter.printTree(tree);
        tree.remove(10);
        BinaryTreePrinter.printTree(tree);
        tree.remove(tree.search(35), 35);
        BinaryTreePrinter.printTree(tree);
    }
}
