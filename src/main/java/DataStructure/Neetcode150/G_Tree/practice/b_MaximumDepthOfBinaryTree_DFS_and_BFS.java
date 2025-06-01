package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BinaryTreeTraversal.BFS;
import DataStructure.Neetcode150.G_Tree.Concept.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class b_MaximumDepthOfBinaryTree_DFS_and_BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(
                        9,
                        new TreeNode(2),
                        new TreeNode(2, new TreeNode(1), new TreeNode(3))))
        );
        BFS.bfs(root);
        System.out.println("maxDepthDFS:: " + maxDepthDFS(root));
        System.out.println("maxDepthBFS:: " + maxDepthBFS(root));
    }

    private static int maxDepthDFS(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    private static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    if(node.left != null)
                        queue.offer(node.left);
                    if(node.right != null)
                        queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
