package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.*;

public class o_BinaryTreeMaximumPathSum {
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
        System.out.println(new o_BinaryTreeMaximumPathSum().maxPathSum(root));
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

        //to find maxSum from within the subtree
        //max of: "root+left+right" or "root" or "root+max(left,right)"
        int sumLeftRootRight =  sumLeft + root.val + sumRight;
        if(root.val > sumLeftRootRight)
            sumLeftRootRight = root.val;
        else if(root.val+Math.max(sumLeft,sumRight) > sumLeftRootRight)
            sumLeftRootRight = root.val+Math.max(sumLeft,sumRight);
        maxSum = Math.max(maxSum, sumLeftRootRight);

        //to find curSum to be returned to parent node of this subtree
        int sumRootMaxLeftRight = root.val + Math.max(sumLeft,sumRight);
        curSum = Math.max(root.val, sumRootMaxLeftRight);
        //to find maxSum for the current subtree
        maxSum = Math.max(maxSum, curSum);

        return curSum;
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
