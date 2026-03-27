package DataStructure.Neetcode150.a_a_Practice.Mock_28_03_26;

import DataStructure.Concepts.Tree.BST.*;
import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(1,2,3,null,null,4,5);
        System.out.println(root);
        SerializeAndDeserializeBinaryTree sbt = new SerializeAndDeserializeBinaryTree();
        String s = sbt.serialize(root);
        System.out.println(s);
        System.out.println(sbt.deserialize(s));
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append(",null");
            return;
        }
        if(!sb.isEmpty()) sb.append(",");
        sb.append(root.val);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    //1,2,null,null,3,4,null,null,5,null,null
    public TreeNode deserialize(String data) {
        String[] sar = data.split(",");
        var list = new LinkedList<String>(List.of(sar));
        return dfs(list);
    }

    private TreeNode dfs(LinkedList<String> list) {
        String s = list.removeFirst();
        if(s.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dfs(list);
        node.right = dfs(list);
        return node;
    }
}
