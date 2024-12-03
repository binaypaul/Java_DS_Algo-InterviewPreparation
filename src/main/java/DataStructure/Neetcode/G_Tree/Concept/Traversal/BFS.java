package DataStructure.Neetcode.G_Tree.Concept.Traversal;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return;
        else
            queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            System.out.println();
            System.out.println(level);
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
        }
    }
}