package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.TreeNode;
import java.util.*;

public class n_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7}; // ro-le-ri
        int[] inorder  = {4,2,5,1,6,3,7}; // le-ro-ri
        /*x
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
             preorder: 1,2,4,5,3,6,7
             inorder:  4,2,5,1,6,3,7
         */
        System.out.println(new n_ConstructBinaryTreeFromPreorderAndInorderTraversal().constructBinaryTree(preorder, inorder));
    }

    private TreeNode constructBinaryTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        var inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        var rootVal = preorder[0];
        var rootIoIdx = inMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = constructBinaryTree(
                Arrays.copyOfRange(preorder, 1, rootIoIdx+1),
                Arrays.copyOfRange(inorder, 0, rootIoIdx));
        root.right = constructBinaryTree(
                Arrays.copyOfRange(preorder, rootIoIdx+1, preorder.length),
                Arrays.copyOfRange(inorder, rootIoIdx+1, inorder.length));
        return root;
    }
}
