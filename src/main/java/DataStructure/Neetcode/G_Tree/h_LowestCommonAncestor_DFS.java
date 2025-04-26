package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class h_LowestCommonAncestor_DFS {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if(p.val < root.val & q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val & q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new h_LowestCommonAncestor_DFS().lowestCommonAncestor(
                TreeNode.create(6,2,8,0,4,7,9,null,null,3,5),
                TreeNode.create(2),
                TreeNode.create(4)
        ).val);
    }
}