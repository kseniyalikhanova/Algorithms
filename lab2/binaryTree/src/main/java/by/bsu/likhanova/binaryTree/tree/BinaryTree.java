package by.bsu.likhanova.binaryTree.tree;

public class BinaryTree {
     static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int value) {
        root = doAdd(root, value);
    }

    private static Node doAdd(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = doAdd(node.left, value);
        } else if (value > node.value) {
            node.right = doAdd(node.right, value);
        }
        return node;
    }

    public Node search(Node node, int value) {
        if (value < node.value) {
            node.left = search(node.left, value);
        } else if (value > node.value) {
            node.right = search(node.right, value);
        }
        return node;
    }

    public void remove(Node node, int value) {
        Node helpNode = search(node, value);
        if (helpNode.left == null) {
            helpNode = helpNode.right;
        } else if (helpNode.right == null) {
            helpNode = helpNode.left;
        } else {
            Node minNode = findMin(helpNode.right);
            helpNode.value = minNode.value;
            remove(minNode, minNode.value);
        }
    }

    private static Node findMin(Node node) {
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }
}
