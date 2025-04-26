package DataStructure.Neetcode.G_Tree.Concept.BinaryTreeTraversal.DFS;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class RecursiveDFS {
    //recursive - start
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
    //recursive - end

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(4,1,3,5,null,1,5,7,6,null,null);
        new RecursiveDFS().inOrder(root);
        System.out.println();
        new RecursiveDFS().preOrder(root);
        System.out.println();
        new RecursiveDFS().postOrder(root);
    }
}
