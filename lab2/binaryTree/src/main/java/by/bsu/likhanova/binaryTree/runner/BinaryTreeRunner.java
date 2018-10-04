package by.bsu.likhanova.binaryTree.runner;

import by.bsu.likhanova.binaryTree.tree.BinaryTree;

import java.io.*;

public class BinaryTreeRunner {
    public static void main(String[] args) throws IOException {
        int[] array = {10,5,11,9,8,15,14,17,0,20,16,35};
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }
    }
}
