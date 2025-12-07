package DataStructure.Neetcode150.G_Tree.practice;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class k_Count_Good_Nodes_In_Binary_Tree_DFS {
    int count = 0;

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int pathmax = Integer.MIN_VALUE;
        dfs(root, pathmax);
        return count;
    }

    private void dfs(TreeNode root, int pathmax) {
        if(root == null) return;

        if(root.val >= pathmax) {
            pathmax = root.val;
            count++;
        }
        dfs(root.left, pathmax);
        dfs(root.right, pathmax);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(2,null,4,10,8,null,null,4);
        System.out.println(root);
        System.out.println(new k_Count_Good_Nodes_In_Binary_Tree_DFS().goodNodes(root));
    }
}
