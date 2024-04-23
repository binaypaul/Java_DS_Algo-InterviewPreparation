package NonLinearDS.Tree.BinaryTree;

import NonLinearDS.Tree.Node;

public class CalculateHeightOfANode {
    private Node node;
    public CalculateHeightOfANode(Node node) {
        this.node = node;
    }
    public int height() {
        return calculateHeight(this.node);
    }

    private int calculateHeight(Node node) {
        if(node == null)
            return 0;
        else {
            int leftHeight = calculateHeight(node.left);
            int rightHeight = calculateHeight(node.right);
            if(leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }
}
