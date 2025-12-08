package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class k_Count_Good_Nodes_In_Binary_Tree_DFS {
    int count = 0;

    public int goodNodes(TreeNode root) {
        int pathMax = Integer.MIN_VALUE;
        dfs(root, pathMax);
        return count;
    }

    public int dfs(TreeNode root, int pathMax) {
        if (root == null)
            return pathMax;

        if(root.val >= pathMax) {
            pathMax = root.val;
            count++;
        }

        dfs(root.left, pathMax);
        dfs(root.right, pathMax);

        return 0; //can return anything from here as returned value from here is not considered.
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(4,1,3,5,null,1,5,7,6,null,null);
        System.out.println(new k_Count_Good_Nodes_In_Binary_Tree_DFS().goodNodes(root));
    }
}
