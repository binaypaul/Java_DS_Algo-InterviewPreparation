package DataStructure.Neetcode150.G_Tree;

//https://leetcode.com/problems/diameter-of-binary-tree/description/

import DataStructure.Neetcode150.G_Tree.Concept.TreeNode;

public class d_DiameterOfBinaryTree_DFS {

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
