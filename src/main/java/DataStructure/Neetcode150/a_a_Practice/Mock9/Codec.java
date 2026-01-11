package DataStructure.Neetcode150.a_a_Practice.Mock9;

import DataStructure.Concepts.Tree.BST.*;
import java.util.*;

/**
 * Serialize and deserialize a binary tree.
 */
public class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeNode.create(1,2,3,null,null,4,5);
        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize("1,2,null,null,3,4,null,null,5,null,null"));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root, "");
    }
    private String preOrder(TreeNode root, String serialized) {
        if(root == null) return serialized+",null";

        serialized=serialized.isBlank()? ""+root.val : serialized+","+root.val;
        serialized = preOrder(root.left, serialized);
        serialized = preOrder(root.right, serialized);
        return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> ll = new LinkedList<>(Arrays.asList(data.split(",")));
        return create(ll);
    }
    //"1,2,null,null,3,4,null,null,5,null,null"
    private TreeNode create(List<String> vals) {
        String cur = vals.removeFirst();

        if(cur.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));

        node.left=create(vals);
        node.right = create(vals);
        return node;
    }
}