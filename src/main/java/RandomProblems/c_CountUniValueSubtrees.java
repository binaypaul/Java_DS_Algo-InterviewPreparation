package RandomProblems;

import DataStructure.Concepts.Tree.BST.TreeNode;

public class c_CountUniValueSubtrees {


    public static void main(String[] args) {
        TreeNode root = TreeNode.create(9,8,9,8,7,null,9,8,null,7,7);
//        TreeNode root = TreeNode.create(5,1,5,5,5,null,5);
//        TreeNode root = TreeNode.create(5,4,5,4,4,null,5);
        System.out.println(new c_CountUniValueSubtrees().countSubTree(root));
    }


    int count = 0;
    public int countSubTree(TreeNode root) {
        isUnivalve(root);
        return count;
    }

    public boolean isUnivalve(TreeNode root) {
        if(root == null) return true;

        boolean leftUni = isUnivalve(root.left);
        boolean rightUni = isUnivalve(root.right);

        if(!leftUni || !rightUni) return false;

        if(root.left != null && root.left.val != root.val) return false;
        if(root.right != null && root.right.val != root.val) return false;

        count++;

        return true;
    }
}
