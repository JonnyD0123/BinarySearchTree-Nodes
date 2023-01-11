package app;

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bst = new BinarySearchTree();

        // populating the BST
        bst.add(8);
        bst.add(6);
        bst.add(10);
        bst.add(2);
        bst.add(7);
        bst.add(4);
        bst.add(1);
        bst.add(6);
        bst.add(3);
        bst.add(5);
        bst.add(9);
        bst.add(11);
        bst.add(14);
        bst.add(12);
        bst.add(20);

        // Print the nodes in the BST in order
        System.out.println(bst.toString());
        // should print true
        System.out.println(bst.isValid());

        // ---- EXAM ---- implement functions in the BST so this works ----

        // swap the nodes that contain 10 and 2
        bst.swapNodes(10, 2);
        // now this will print out of order
        System.out.println(bst.toString());
        // should print false
        System.out.println(bst.isValid());
        // this will fix the tree
        bst.fixTree();
        // now this will print back in order
        System.out.println(bst.toString());
        // should print true again
        System.out.println(bst.isValid());
        // ---- END OF EXAM ----
    }
}