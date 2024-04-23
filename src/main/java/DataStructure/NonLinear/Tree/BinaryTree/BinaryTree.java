package NonLinearDS.Tree.BinaryTree;

import NonLinearDS.Tree.Node;

public class BinaryTree {
    Node root;
    private int[] sortedArray;
    public BinaryTree(int[] sortedArray) {
        this.sortedArray = sortedArray;
        root = null;
    }

    public Node create() {
        return insertLevelOrder(root, 0);
    }
    // Function to insert nodes in level order
    private Node insertLevelOrder(Node root, int i) {
        // Base case for recursion
        if (i < sortedArray.length) {
            root = new Node(sortedArray[i]);
            // insert left child
            root.left = insertLevelOrder(root.left, 2 * i + 1);
            // insert right child
            root.right = insertLevelOrder(root.right, 2 * i + 2);
        }
        return root;
    }


}
