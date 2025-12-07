package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BinaryTreeTraversal.BFS;
import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

public class d_DiameterOfBinaryTree_DFS {
    int maxDia = 0;

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(4,
                    new TreeNode(2,
                            new TreeNode(1),
                            new TreeNode(3)),
                    new TreeNode(7,
                            new TreeNode(6,
                                    new TreeNode(5,
                                            new TreeNode(4,
                                                    new TreeNode(2),
                                                    new TreeNode(3)),
                                            new TreeNode(7)),
                                    new TreeNode(8)),
                            new TreeNode(9,
                                    new TreeNode(2),
                                    new TreeNode(2,
                                            new TreeNode(1,
                                                    new TreeNode(4),
                                                    new TreeNode(5)),
                                            new TreeNode(3))))
        );
        BFS.bfs(root);
        System.out.println("max dia:: " + new d_DiameterOfBinaryTree_DFS().maxDia(root));
    }

    public int maxDia(TreeNode root) {
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int lMaxDepth = dfs(root.left);
        int rMaxDepth = dfs(root.right);
        maxDia = Math.max(maxDia,lMaxDepth+rMaxDepth);
        return 1 + Math.max(lMaxDepth, rMaxDepth);
    }
}
