package DataStructure.Neetcode150.a_a_Practice.March.Mock_30_03_26;

import DataStructure.Concepts.Tree.BST.*;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(-10);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root, 0);
        return maxSum;
    }
    private int dfs(TreeNode root, int curSum) {
        if(root==null)
            return 0;
        int sumLeft = dfs(root.left, curSum);
        int sumRight = dfs(root.right, curSum);

        //to find maxSum for within the current tree
        int sumLeftRootRight =  sumLeft + root.val + sumRight;
        if(root.val > sumLeftRootRight) sumLeftRootRight = root.val;
        else if(root.val+sumLeft > sumLeftRootRight) sumLeftRootRight = root.val+sumLeft;
        else if(root.val+sumRight > sumLeftRootRight) sumLeftRootRight = root.val+sumRight;
        maxSum = Math.max(maxSum, sumLeftRootRight);

        //to find maxSum for within the current tree
        int sumRootMaxLeftRight = root.val + Math.max(sumLeft,sumRight);
        curSum = Math.max(root.val, sumRootMaxLeftRight);
        maxSum = Math.max(maxSum, curSum);

        return curSum;
    }
/*
    -10
     /  \
    44   20
         / \
        15   7
*/
}
