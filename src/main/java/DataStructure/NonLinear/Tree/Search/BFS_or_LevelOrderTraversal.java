package NonLinearDS.Tree.Search;

import NonLinearDS.Tree.BinaryTree.CalculateHeightOfANode;
import NonLinearDS.Tree.Node;
/**
 ** Note:
 ** Most problems in NonLinearDS.Tree are solved using recursion which involves following steps:
 * 1. Recursive calls are made to reach the leaf node of the tree.
 * 2. From the leaf node, the control/execution goes down-to-top of the tree and computes the solution.
 ** This two steps are termed as "Backtracking" algorithm of NonLinearDS.Tree Data Structure.
 */
public class BFS_or_LevelOrderTraversal {
    private Node root;
    public BFS_or_LevelOrderTraversal(Node root) {
        this.root = root;
    }

    public void printLevelOrder() {
        //calculate the height of the NonLinearDS.Tree
        int height = new CalculateHeightOfANode(root).height();
        for(int n = 1; n <= height; n++) {
            printNthLevel(root, n);
        }
    }

    public void printNthLevel(Node root, int n) {
        if(root != null) {
            if(n == 1) {
                System.out.print(root.data + " ");
            } else {
                printNthLevel(root.left, n-1);
                printNthLevel(root.right, n-1);
            }
        }
    }
}
