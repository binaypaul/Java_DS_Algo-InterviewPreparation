package DataStructure.Neetcode.G_Tree.practice;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * <p>
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */


import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class a_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        root.toString();
        invertTree(root).toString();
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
