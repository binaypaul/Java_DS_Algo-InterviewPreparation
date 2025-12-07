package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/description/
//Given a binary tree, determine if it is height-balanced.
//A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

public class e_BalancedBinaryTree_DFS {

    //Solution - start
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root != null)
            dfs(root);

        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int ld = dfs(root.left);
        int rd = dfs(root.right);
        if(Math.abs(ld-rd) > 1){
            isBalanced = false;
        }
        return 1 + Math.max(ld,rd);
    }
    //Solution - end



    public static void main(String[] args) {
        TreeNode root = TreeNode.create(3,9,20,null,null,15,7);
        System.out.println(root.toString());
        System.out.println(new e_BalancedBinaryTree_DFS().isBalanced(root));
    }
}
