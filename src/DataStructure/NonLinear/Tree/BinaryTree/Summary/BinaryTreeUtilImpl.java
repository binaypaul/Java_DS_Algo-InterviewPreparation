package NonLinearDS.Tree.BinaryTree.Summary;

public class BinaryTreeUtilImpl implements BinaryTreeUtil {
    /**
     * Creates binary tree from a sorted array.
     *
     * @param sortedArray - int[] - elements in array sorted in ascending order.
     * @return BinaryTree
     */
    @Override
    public BinaryTree createBinaryTree(int[] sortedArray) {
        Node root = insertLevelOrder(sortedArray, null, 0);
        return new BinaryTree(root);
    }
    private Node insertLevelOrder(int[] sortedArray, Node root, int i) {
        if (i < sortedArray.length) {
            root = new Node(sortedArray[i]);
            root.left = insertLevelOrder(sortedArray, root.left, 2*i+1);
            root.right = insertLevelOrder(sortedArray, root.right, 2*i+2);
        }
        return root;
    }

    @Override
    public void levelOrderTraversalBFS(Node root) {
        int heightOfRoot = heightOfNode(root);
        for (int i = 0; i < heightOfRoot; i++) {
            levelOrderTraversalBFS(root, i);
        }
    }

    private void levelOrderTraversalBFS(Node root, int i) {
        if(i == 0) {
            System.out.print(root.data + " ");
            return;
        }
        levelOrderTraversalBFS(root.left, i-1);
        levelOrderTraversalBFS(root.right, i-1);
    }

    /**
     * Traverses binary tree in inOrder DFS.
     *
     * @param root root node of the tree.
     */
    @Override
    public void inOrderTraversalDFS(Node root) {
        if(root != null) {
            inOrderTraversalDFS(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalDFS(root.right);
        }
    }

    /**
     * Traverses binary tree in preOrder DFS.
     *
     * @param root root node of the tree.
     */
    @Override
    public void preOrderTraversalDFS(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrderTraversalDFS(root.left);
            preOrderTraversalDFS(root.right);
        }
    }

    /**
     * Traverses binary tree in postOrder DFS.
     *
     * @param root root node of the tree.
     */
    @Override
    public void postOrderTraversalDFS(Node root) {
        if(root != null) {
            preOrderTraversalDFS(root.left);
            preOrderTraversalDFS(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Calculates height of a node.
     *
     * @param node node of the tree for which height is to be calculated
     * @return int[]
     */
    @Override
    public int heightOfNode(Node node) {
        if(node == null)
            return 0;
        int lHeight = heightOfNode(node.left);
        int rHeight = heightOfNode(node.right);
        if(lHeight > rHeight) {
            lHeight+=1;
            return lHeight;
        } else {
            rHeight+=1;
            return rHeight;
        }
    }

    /**
     * Calculates depth of a node.
     *
     * @param root root node of the tree
     * @param node node of the tree for which depth is to be calculated
     */
    @Override
    public int depthOfNode(Node root, Node node) {
        if(root == node) {
            return 0;
        }
        if(root == null) {
            return -1;
        }
        int lDepth = depthOfNode(root.left, node);
        int rDepth = depthOfNode(root.right, node);
        if(lDepth > rDepth) {
            return ++lDepth;
        } else if(rDepth > lDepth) {
            return ++rDepth;
        } else {
            return -1;
        }
    }
}
