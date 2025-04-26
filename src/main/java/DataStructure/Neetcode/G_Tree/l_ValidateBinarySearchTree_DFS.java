package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/description/
/**
 * NOTE: In-order DFS Traversal prints a BST in smallest-to-largest order.
 */

public class l_ValidateBinarySearchTree_DFS {
    boolean valid = true;
    Integer prevVal;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            valid = false;
        inorderDfs(root);
        return valid;
    }

    private void inorderDfs(TreeNode root) {
        //base condition
        if(root == null)
            return;

        //To avoid unnecessary iteration
        if(!valid)
            return;

        inorderDfs(root.left);

        //To avoid unnecessary iteration
        if(!valid)
            return;

        if(null != prevVal) {
            valid = root.val > prevVal;
        }

        prevVal = root.val;

        //To avoid unnecessary iteration
        if(!valid)
            return;

        inorderDfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(-2147483648,null,2147483647);
        System.out.println(new l_ValidateBinarySearchTree_DFS().isValidBST(root));
    }
}

//5,1,4,null,null,3,6 - invalid
//3,1,5,null,null,4,6 - valid