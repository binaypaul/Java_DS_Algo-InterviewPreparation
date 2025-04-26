package DataStructure.Neetcode.G_Tree.Concept;

import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

@ToString
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

    public static TreeNode create(Integer... values) {
        if(values == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        q.add(root);

        int valIndex = 1, valSize = values.length;
        while (!q.isEmpty() & valIndex < valSize) {
            for (int i = 0; i < q.size() & valIndex < valSize; i++) {
                TreeNode node = q.remove();

                if(null == values[valIndex])
                    valIndex++;
                else {
                    node.left = new TreeNode(values[valIndex++]);
                    q.add(node.left);
                }

                if(valIndex < valSize) {
                    if (null == values[valIndex])
                        valIndex++;
                    else {
                        node.right = new TreeNode(values[valIndex++]);
                        q.add(node.right);
                    }
                }
            }
        }
        return root;
    }
}
