package DataStructure.Neetcode.G_Tree.Concept.Traversal;

import DataStructure.Neetcode.G_Tree.Concept.BST;
import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class TreeTraversalTest {
    public static void main(String[] args) {
        BST bst = new BST();

        Integer[] values = new Integer[] {8,3,10,1,6,14,4,7,13};
        TreeNode root = bst.createBST(values);

        DFS dfs = new DFS();
        dfs.inOrder(root);
        System.out.println();

        BFS bfs = new BFS();
        bfs.bfs(root);

    }
}
