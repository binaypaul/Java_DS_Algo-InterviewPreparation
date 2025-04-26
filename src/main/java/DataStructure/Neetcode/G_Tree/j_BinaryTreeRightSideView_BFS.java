package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/description/ (check discussion to better understand the description)

public class j_BinaryTreeRightSideView_BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if(i == size-1) {
                    list.add(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(1,2,3,4,null,null,null,5);
        System.out.println(new j_BinaryTreeRightSideView_BFS().rightSideView(root));
    }
}
