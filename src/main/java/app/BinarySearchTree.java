package app;

import javax.management.InstanceNotFoundException;
import java.util.*;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(int data) {
        this.root = this.addNode(root, data);
    }

    public Node search(Node root, int data) {
        // root is null or data is present at root
        if (root==null || root.data==data)
            return root;

        // Data is greater than root's data
        if (root.data < data)
            return search(root.right, data);

        // Data is smaller than root's data
        return search(root.left, data);
    }

    public boolean swapNodes(int firstValue, int secondValue) {
        Node n1 = null;
        Node n2 = null;

        try {
            n1 = search(root, firstValue);
        } catch (Exception e) {
            return false;
        }

        try {
            n2 = search(root, secondValue);
        } catch (Exception e) {
            return false;
        }

        Node temp = new Node (0);
        temp.data = n1.data;
        n1.data = n2.data;
        n2.data = temp.data;

        return true;
    }

    public boolean isValid() {
        return isValid(root);
    }

    public boolean isValid(Node root) {
        if (root == null)
            return true;
        if ((root.left != null) && (root.left.data > root.data))
            return false;
        if ((root.right != null) && (root.right.data < root.data))
            return false;
        boolean leftSide = isValid(root.left);
        boolean rightSide = isValid(root.right);

        if(leftSide && rightSide)
            return true;
        else
            return false;
    }

    public boolean fixTree() {
        Node firstNode = null;
        Node secondName = null;
        Node current = root;
        Node previous = null;

        Stack<Node> nodeStack = new Stack<>();
        while(!nodeStack.isEmpty() ||  current != null){
            if(current != null){
                nodeStack.push(current);
                current = current.left;
            }else {
                current = nodeStack.pop();

                if(previous != null && current.data <= previous.data){
                    if(firstNode == null) firstNode = previous;
                    secondName = current;
                }
                previous = current;
                current = current.right;
            }
        }

        int temp = firstNode.data;
        firstNode.data = secondName.data;
        secondName.data = temp;

        if(this.isValid())
            return true;
        else
            return false;
    }

    private Node addNode(Node current, int data) {
        // time to insert node
        if (current == null) {
            return new Node(data);
        }

        // compare the data to the current node to see which way to traverse
        if (data < current.data) {
            current.left = this.addNode(current.left, data);
        } else if (data > current.data) {
            current.right = this.addNode(current.right, data);
        }

        // if the data is already there, just return current
        return current;
    }

    @Override
    public String toString() {
        String result = this.inOrderTraversal(this.root);
        return result.trim();
    }

    private String inOrderTraversal(Node current) {
        StringBuilder strBldr = new StringBuilder();

        // check if we have anything to add to the string
        if (current != null) {
            // go left first because this is inorder
            strBldr.append(this.inOrderTraversal(current.left));

            // no print the current node
            strBldr.append(current.data + " ");

            // go right last because inorder
            strBldr.append(this.inOrderTraversal(current.right));
        }

        return strBldr.toString();
    }
}