package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.Traversal.BFS;
import DataStructure.Neetcode.G_Tree.Concept.TreeNode;
//https://leetcode.com/problems/invert-binary-tree/description/

public class a_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        new BFS().bfs((root));
        new BFS().bfs(invertTree(root));
    }

    private static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        if(root.right!=null)
            root.right = invertTree(root.right);
        if(root.left!=null)
            root.left = invertTree(root.left);

        return root;
    }

}
