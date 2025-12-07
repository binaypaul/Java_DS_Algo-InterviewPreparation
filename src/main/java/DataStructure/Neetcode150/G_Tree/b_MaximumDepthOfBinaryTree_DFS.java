package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class b_MaximumDepthOfBinaryTree_DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(
                        9,
                        new TreeNode(2),
                        new TreeNode(2, new TreeNode(1), new TreeNode(3))))
        );

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
