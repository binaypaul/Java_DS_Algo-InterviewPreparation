package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.*;

public class q_BinaryTreeMaximumPathSum_Simple {
    public static void main(String[] args) {
//        TreeNode root = TreeNode.create(-10,44,20,null,null,15,7);
/*
    -10
     /  \
    44   20
         / \
        15   7
*/
        TreeNode root = TreeNode.create(-1,null,9,-6,3,null,null,null,-2);
/*
       -1
         \
          9
         / \
       -6   3
             \
             -2
*/
        System.out.println(root);
        System.out.println(new q_BinaryTreeMaximumPathSum_Simple().maxPathSum(root));
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root)
    {
        if(root == null) return 0;
        //if left subtree is returning negative value,
        //then ignore the left subtree's negative value by finding max(0,"negative value") will always return 0.
        //as adding negative value will decrease the sum.
        //hence max of 0, negative value.
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left + root.val + right);

        return Math.max(left,right) + root.val;
    }
/*
       -1
         \
          9
         / \
       -6   3
             \
             -2
*/
}
