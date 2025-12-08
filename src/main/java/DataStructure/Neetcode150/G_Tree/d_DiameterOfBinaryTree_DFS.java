package DataStructure.Neetcode150.G_Tree;

//https://leetcode.com/problems/diameter-of-binary-tree/description/

import DataStructure.Concepts.Tree.BST.TreeNode;
/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 */

public class d_DiameterOfBinaryTree_DFS {

    //Solution - start
    private int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        maxDia = Math.max(maxDia, (leftDepth + rightDepth)); // find diameter

        return 1 + Math.max(leftDepth,rightDepth);//find depth
    }
    //Solution - end

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2),null
        );
        int maxDia = new d_DiameterOfBinaryTree_DFS().diameterOfBinaryTree(root);
        System.out.println(maxDia);
    }
}
