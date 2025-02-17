package DataStructure.Neetcode.G_Tree.Concept;

import DataStructure.Neetcode.G_Tree.Concept.Traversal.BFS;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "root: " + val +
                " leftNode: " + ((left != null) ? left.val : "null") +
                " rightNode: " + ((right != null) ? right.val : "null");
    }
    public void print (){
        new BFS().bfs(this);
    }
}
