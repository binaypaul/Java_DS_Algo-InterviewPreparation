package NonLinearDS.Tree.BinaryTree;

import NonLinearDS.Tree.Node;

public class CalculateDepthOfANode {
    Node root;
    Node node;
    public CalculateDepthOfANode(Node root, Node node) {
        this.root = root;
        this.node = node;
    }

    public int calculateDepth() {
        return calculateDepth(this.root, this.node);
    }

    private int calculateDepth(Node root, Node node) {
        if(root == null) {
            return -1;
        } else if(root == node) {
            return 0;
        }
        int leftDepth = calculateDepth(root.left, node);
        int rightDepth = calculateDepth(root.right, node);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else if(rightDepth > leftDepth){
            return rightDepth + 1;
        } else {
            return leftDepth;
        }
    }
}
