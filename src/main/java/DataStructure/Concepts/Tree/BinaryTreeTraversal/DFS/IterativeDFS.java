package DataStructure.Concepts.Tree.BinaryTreeTraversal.DFS;

import DataStructure.Concepts.Tree.BST.TreeNode;

import java.util.Stack;

public class IterativeDFS {
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            if(curr != null) {
                System.out.print(curr.val + " ");
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visitStack = new Stack<>();

        stack.push(root); visitStack.push(false);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            boolean visited = visitStack.pop();
            if(null != cur) {
                if (visited)
                    System.out.print(cur.val + " ");
                else {
                    stack.push(cur);        visitStack.push(true);
                    stack.push(cur.right);  visitStack.push(false);
                    stack.push(cur.left);   visitStack.push(false);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(4,1,3,5,null,1,5,7,6,null,null);

//        new RecursiveDFS().inOrder(root);
//        System.out.println();
//        new IterativeDFS().inOrder(root);
//        System.out.println();
//
//        new RecursiveDFS().preOrder(root);
//        System.out.println();
//        new IterativeDFS().preOrder(root);
//        System.out.println();

        new RecursiveDFS().postOrder(root);
        System.out.println();
        new IterativeDFS().postOrder(root);
        System.out.println();
    }
}
