package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

class Info {
    int diameter;
    int height;

    public Info(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class c_DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(new c_DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info ans = fun(root);
        return ans.diameter;
    }

    public Info fun(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftData = fun(root.left);
        Info rightData = fun(root.right);

        int currDiameter = Math.max(Math.max(leftData.diameter, rightData.diameter), (leftData.height + rightData.height));
        int currHeight = Math.max(leftData.height, rightData.height) + 1;

        return new Info(currDiameter, currHeight);
    }
}