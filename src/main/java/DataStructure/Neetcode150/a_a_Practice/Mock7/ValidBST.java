package DataStructure.Neetcode150.a_a_Practice.Mock7;

import DataStructure.Concepts.Tree.BST.*;


public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(4,2,6,1,3,7,7);
        System.out.println(new ValidBST().isValidBST(root));

    }

    boolean valid = true;
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return valid;
    }

    public void inOrder(TreeNode root) {
        if(root==null)
            return;
        if(!valid) {
            return;
        }
        inOrder(root.left);
        if (prev != null) {
            valid = prev < root.val;
        }
        prev = root.val;
        inOrder(root.right);
    }
}