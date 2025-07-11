package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BinaryTreeTraversal.BFS;
import DataStructure.Neetcode150.G_Tree.Concept.TreeNode;
//https://leetcode.com/problems/invert-binary-tree/description/

public class a_InvertBinaryTree_DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        BFS.bfs((root));
        BFS.bfs(invertTree(root));
    }

    private static TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}