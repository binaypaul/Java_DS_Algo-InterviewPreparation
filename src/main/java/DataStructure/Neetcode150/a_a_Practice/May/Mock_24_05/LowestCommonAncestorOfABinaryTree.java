package DataStructure.Neetcode150.a_a_Practice.May.Mock_24_05;

import DataStructure.Concepts.Tree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p = TreeNode.create(5);
        TreeNode q = TreeNode.create(1);
        System.out.println(root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if(p.val < root.val & q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val & q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
