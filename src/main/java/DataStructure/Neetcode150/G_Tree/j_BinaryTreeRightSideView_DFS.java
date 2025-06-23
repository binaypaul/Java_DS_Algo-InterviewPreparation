package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.TreeNode;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/description/ (check discussion to better understand the description)

public class j_BinaryTreeRightSideView_DFS {
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(1,2,3,null,5,null,4);
        System.out.println(new j_BinaryTreeRightSideView_DFS().rightSideView(root));
    }
}
