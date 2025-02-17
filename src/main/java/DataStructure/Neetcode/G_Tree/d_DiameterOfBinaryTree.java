package DataStructure.Neetcode.G_Tree;

//https://leetcode.com/problems/diameter-of-binary-tree/description/

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class d_DiameterOfBinaryTree {

    //Solution - start
    private int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        maxDia = Math.max(maxDia, (leftDepth + rightDepth));

        return 1 + Math.max(leftDepth,rightDepth);
    }
    //Solution - end

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2),null
        );
        int maxDia = new d_DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println(maxDia);
    }
}
