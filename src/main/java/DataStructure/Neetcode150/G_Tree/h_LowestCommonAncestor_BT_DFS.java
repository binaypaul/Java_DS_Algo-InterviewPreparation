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
            // read notes why leftAns is returned
            return leftAns;
        } else if (leftAns == null && rightAns != null) {
            // read notes why rightAns is returned
            return rightAns;
        } else {
            return root;
        }
    }
}
/*
Notes:
    * leftAns is returned because :
        eg: p=5, q=7:
            5 returned to 3 from left subtree of 3 (leftAns)
            null is returned from right subtree of 3 (rightAns)
            O/P: 5 (leftAns)

        eg: p=2, q=4
            2 returned to 5 from right subtree of 5 (rightAns)
            null is returned from left subtree of 5 (rightAns)
            O/P: 2 (rightAns)
 */