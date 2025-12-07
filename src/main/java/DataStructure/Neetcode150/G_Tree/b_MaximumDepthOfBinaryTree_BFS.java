package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class b_MaximumDepthOfBinaryTree_BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(
                        9,
                        new TreeNode(2),
                        new TreeNode(2, new TreeNode(1), new TreeNode(3))))
        );
        root.toString();
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        if(root == null) {
            return depth;
        } else {
            q.add(root);
        }

        while (!q.isEmpty()) {
            ++depth;
            for(int size = q.size(); size > 0; size--) {
                TreeNode node = q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }

        return depth;
    }
}
