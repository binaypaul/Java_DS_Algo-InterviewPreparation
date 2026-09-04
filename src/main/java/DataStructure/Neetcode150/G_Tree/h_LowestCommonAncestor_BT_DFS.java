package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.*;
import DataStructure.Practice.September2026._04.M1.*;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//https://youtu.be/_-QHfMDde90?t=323
public class h_LowestCommonAncestor_BT_DFS {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(7);
        System.out.println(new LowestCommonAncestorOfABinaryTree()
                .lowestCommonAncestor(root, p, q));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

        if(leftAns == null && rightAns == null) {
            return null;
        } else if (leftAns != null && rightAns == null) {
            return root;
        } else if (leftAns == null && rightAns != null) {
            return root;
        } else {
            return root;
        }
    }
}
