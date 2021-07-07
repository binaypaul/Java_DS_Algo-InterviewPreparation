package NonLinearDS.Tree.BinaryTree.Summary;

public interface BinaryTreeUtil {
    /**
     * Creates binary tree from a sorted array.
     *
     * @param sortedArray - int[] - elements in array sorted in ascending order.
     * @return BinaryTree
     */
    BinaryTree createBinaryTree(int[] sortedArray);

    /**
     * Traverses binary tree in level order or BFS.
     * @param root root node of the tree.
     */
    void levelOrderTraversalBFS(Node root);

    /**
     * Traverses binary tree in inOrder DFS.
     * @param root root node of the tree.
     */
    void inOrderTraversalDFS(Node root);

    /**
     * Traverses binary tree in preOrder DFS.
     * @param root root node of the tree.
     */
    void preOrderTraversalDFS(Node root);

    /**
     * Traverses binary tree in postOrder DFS.
     * @param root root node of the tree.
     */
    void postOrderTraversalDFS(Node root);

    /**
     * Calculates height of a node.
     * @param node node of the tree for which height is to be calculated
     * @return int
     */
    int heightOfNode(Node node);

    /**
     * Calculates depth of a node.
     *
     * @param root root node of the tree
     * @param node node of the tree for which depth is to be calculated
     * @return int
     */
    int depthOfNode(Node root, Node node);
}
