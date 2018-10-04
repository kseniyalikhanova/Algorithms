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

    public Node search(int value) {
        Node node = search(root, value);
        return node;
    }

    public Node search(Node node, int value) {
        if(node == null){
            return null;
        }
        if (value < node.value) {
            node.left = search(node.left, value);
        } else if (value > node.value) {
            node.right = search(node.right, value);
        }
        return node;
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value
                ? containsNodeRecursive(node.left, value)
                : containsNodeRecursive(node.right, value);
    }

    public void remove(int value) {
        remove(root, value);
    }

    public Node remove(Node node, int value) {
        if (value < node.value) {
            node.left = remove(node.left, value);
            return node;
        }
        if (value > node.value) {
            node.right = remove(node.right, value);
            return node;
        }
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            Node minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = remove(node.right, minNode.value);
            return node;
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
