package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/description/ (check discussion to better understand the description)

public class j_BinaryTreeRightSideView_BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(1,2,3,null,5,null,4);
        System.out.println(new j_BinaryTreeRightSideView_BFS().rightSideView(root));
    }
}
