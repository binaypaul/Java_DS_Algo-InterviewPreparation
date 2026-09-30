package DataStructure.Practice.Sept2026._17_2;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root==null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node prev = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if(prev!=null) {
                    prev.next=cur;
                    if(cur==null && !q.isEmpty()) {
                        q.offer(null);
                    }
                }
                prev=cur;

                if(cur!=null) {
                    if(cur.left!=null)
                        q.offer(cur.left);
                    if(cur.right!=null)
                        q.offer(cur.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        var ret = populatingNextRightPointersInEachNode.connect(root);
        System.out.println(ret);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val) { this.val = val; }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }
}
