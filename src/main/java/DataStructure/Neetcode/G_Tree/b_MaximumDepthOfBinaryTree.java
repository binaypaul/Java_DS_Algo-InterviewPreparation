package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class b_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(
                        9,
                        new TreeNode(2),
                        new TreeNode(2, new TreeNode(1), new TreeNode(3))))
        );

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0, 0);
    }

    public static int getMaxDepth(TreeNode root, int depth, int maxDepth) {
        if(root == null) {
            return Math.max(depth, maxDepth);
        } else {
            depth+=1;
        }

        maxDepth = getMaxDepth(root.left, depth, maxDepth);
        maxDepth = getMaxDepth(root.right, depth, maxDepth);
        return maxDepth;
    }
}
