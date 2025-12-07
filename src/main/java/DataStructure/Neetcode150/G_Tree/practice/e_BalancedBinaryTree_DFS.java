package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BinaryTreeTraversal.BFS;
import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/description/
// Given a binary tree, determine if it is height-balanced.
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
// never differs by more than one.

public class e_BalancedBinaryTree_DFS {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(3,9,20,null,null,15,7);
        BFS.bfs(root);
        System.out.println(root);
        System.out.println(new e_BalancedBinaryTree_DFS().isBalanced(root));
    }

    private boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int ld = maxdepth(root.left);
        int rd = maxdepth(root.right);
        if(Math.abs(ld-rd) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxdepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxdepth(root.left), maxdepth(root.right));
    }
}
