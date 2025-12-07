package DataStructure.Neetcode150.G_Tree.Concept.BinaryTreeTraversal;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(TreeNode root) {
        System.out.println("-------------------------------------------------------------");
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return;
        else
            queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            System.out.println("level="+level);
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.remove();
                System.out.print(node.val + " ");

                if(null != node.left)
                    queue.add(node.left);
                if(null != node.right)
                    queue.add(node.right);
            }
            level+=1;
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");
    }
}
