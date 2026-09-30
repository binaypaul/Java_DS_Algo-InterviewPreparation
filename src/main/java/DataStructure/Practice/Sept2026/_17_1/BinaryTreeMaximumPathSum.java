package DataStructure.Practice.Sept2026._17_1;

import DataStructure.Concepts.Tree.*;

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root==null) return 0;

        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, leftSum + root.val + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        var ret = binaryTreeMaximumPathSum.maxPathSum(root);//42
        System.out.println(ret);
    }
    /*
    -10
  9     20
      15   7
     */
}