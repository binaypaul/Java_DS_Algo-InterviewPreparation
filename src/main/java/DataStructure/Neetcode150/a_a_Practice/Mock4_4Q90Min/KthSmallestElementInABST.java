package DataStructure.Neetcode150.a_a_Practice.Mock4_4Q90Min;

import java.util.*;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
        Node root = new Node(3, new Node(1, null, new Node(2)), new Node(4));
        System.out.println(new KthSmallestElementInABST().findKthSmallest(root, 3));
    }

    private int findKthSmallest(Node root, int k) {
        var list = new ArrayList<Integer>();
        prefixDFS(root, list);
        return list.get(k-1);
    }

    private void prefixDFS(Node root, ArrayList<Integer> list) {
        if(root == null) return;
        prefixDFS(root.left, list);
        list.add(root.val);
        prefixDFS(root.right, list);
    }
}
class Node {
    int val;
    Node left, right;
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public Node(int val) {
        this.val = val;
    }
}