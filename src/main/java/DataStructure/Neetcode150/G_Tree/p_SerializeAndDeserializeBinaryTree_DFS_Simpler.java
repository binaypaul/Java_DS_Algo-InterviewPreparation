package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.*;
import java.util.*;

public class p_SerializeAndDeserializeBinaryTree_DFS_Simpler {
    public static void main(String[] args) {
        p_SerializeAndDeserializeBinaryTree_DFS_Simpler codec = new p_SerializeAndDeserializeBinaryTree_DFS_Simpler();

//        TreeNode root = TreeNode.create(1,2,3,null,null,4,5);
        TreeNode root = null;
/*
        1
       / \
      2   3
         / \
        4   5
*/
        String s = codec.serialize(root);
        System.out.println(s);// 1,2,null,null,3,4,null,null,5,null,null
        System.out.println(codec.deserialize(s));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",null");
            return;
        }
        if (!sb.isEmpty()) sb.append(",");
        sb.append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> al = new LinkedList<>(Arrays.asList(data.split(",")));
        return create(al);
    }
    // 1,2,null,null,3,4,null,null,5,null,null
    private TreeNode create(List<String> ll) {
        String cur = ll.removeFirst();

        if(cur.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(cur));

        node.left=create(ll);
        node.right=create(ll);
        return node;
    }
}
