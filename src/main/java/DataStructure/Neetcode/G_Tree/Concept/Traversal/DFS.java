package DataStructure.Neetcode.G_Tree.Concept.Traversal;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class DFS {

    public void inOrder(TreeNode root) {
        if(null == root) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if(null == root) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
