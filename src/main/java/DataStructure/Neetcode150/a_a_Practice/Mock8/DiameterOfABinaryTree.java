package DataStructure.Neetcode150.a_a_Practice.Mock8;

import DataStructure.Concepts.Tree.BST.*;
import java.util.*;

public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        System.out.println(new DiameterOfABinaryTree().diameter(TreeNode.create(1,2,3,4,5)));
    }
    int diameter = 0;
    private int diameter(TreeNode root) {
        findDepth(root);
        return diameter;
    }

    private int findDepth(TreeNode root) {
        if (root == null) return 0;
        int ld = findDepth(root.left);
        int rd = findDepth(root.right);
        diameter = Math.max(diameter, ld+rd);
        return 1+Math.max(ld,rd);
    }
}
