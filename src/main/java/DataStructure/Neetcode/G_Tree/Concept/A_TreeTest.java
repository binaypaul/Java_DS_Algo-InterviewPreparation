package DataStructure.Neetcode.G_Tree.Concept;

import DataStructure.Neetcode.G_Tree.Concept.Traversal.BFS;
import DataStructure.Neetcode.G_Tree.Concept.Traversal.DFS;

public class A_TreeTest {
    public static void main(String[] args) {
        BST bst = new BST();

        int[] values = new int[] {8,3,10,1,6,14,4,7,13};
        TreeNode root = bst.createBST(values);
        System.out.println(bst.search(root, 3));


        DFS dfs = new DFS();
        dfs.inOrder(root);
        System.out.println();

        BFS bfs = new BFS();
        bfs.bfs(root);

//        System.out.println(bst.findMin(root));
//        bst.remove(root, 3);

    }
}
