package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.Traversal.BFS;
import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class a_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        new BFS().bfs(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;

        if(root.left != null)
            invertTree(root.left);
        if(root.right != null)
            invertTree(root.right);

        return root;
    }
}
