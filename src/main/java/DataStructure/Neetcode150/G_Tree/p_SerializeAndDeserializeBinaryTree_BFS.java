package DataStructure.Neetcode150.G_Tree;

import DataStructure.Concepts.Tree.BST.*;
import java.util.*;

public class p_SerializeAndDeserializeBinaryTree_BFS {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(1,null,2,null,3);
        System.out.println(root);
        p_SerializeAndDeserializeBinaryTree_BFS sbt = new p_SerializeAndDeserializeBinaryTree_BFS();
        String s = sbt.serialize(root);
        System.out.println(s);
        System.out.println(sbt.deserialize(s));
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode polled = q.poll();
            if(polled == null) {
                sb.append("null").append(",");
            } else {
                sb.append(polled.val).append(",");
                q.offer(polled.left);
                q.offer(polled.right);
            }
        }
        if(!sb.isEmpty() && sb.charAt(sb.length()-1)==',')
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] dataArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i < dataArr.length) {
            TreeNode node = q.poll();
            // Process left child
            if(!dataArr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(dataArr[i]));
                q.offer(node.left);
            }
            i++;
            // Process right child
            if(i < dataArr.length && !dataArr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(dataArr[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}