package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

import java.util.*;
//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class i_BinaryTreeLevelOrderTraversal_BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> listChild = new ArrayList<>(qSize);
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.remove();
                listChild.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            list.add(listChild);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new i_BinaryTreeLevelOrderTraversal_BFS().levelOrder(TreeNode.create(3,9,20,null,null,15,7)));
    }
}
