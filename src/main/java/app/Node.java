package app;

public class Node {
    // the two children of this node
    Node left;
    Node right;

    // we are just storing ints in this node
    Integer data;

    // just one constructor, I don't want to create empty nodes
    public Node(Integer data) {
        this.data = data;
    }
}