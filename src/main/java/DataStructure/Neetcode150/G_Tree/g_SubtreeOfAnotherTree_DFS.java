package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.TreeNode;
//https://leetcode.com/problems/subtree-of-another-tree/description/

public class g_SubtreeOfAnotherTree_DFS {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return (isSameTree(root, subRoot)
                || ((root!=null)? isSubtree(root.left, subRoot):false)
                || ((root!=null)? isSubtree(root.right, subRoot):false));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        } else if (p==null && q!=null) {
            return false;
        } else if (p!=null && q==null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(3,4,5,1,2);
        TreeNode subRoot = TreeNode.create(4,1,2);
        System.out.println(new g_SubtreeOfAnotherTree_DFS().isSubtree(root, subRoot));
    }
}
