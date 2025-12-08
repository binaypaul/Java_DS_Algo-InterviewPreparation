package DataStructure.Concepts.Tree.BinaryTreeTraversal.DFS;

import DataStructure.Concepts.Tree.BST.TreeNode;

public class RecursiveDFS {
    //recursive - start
    //! In order traversal prints a Binary Search Tree in ascending order.
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
        TreeNode root = TreeNode.create(10,5,15,2,8,12,18,1,3,6,9,11,13,16,19);
        new RecursiveDFS().inOrder(root);
        System.out.println();
        new RecursiveDFS().preOrder(root);
        System.out.println();
        new RecursiveDFS().postOrder(root);
    }
}
