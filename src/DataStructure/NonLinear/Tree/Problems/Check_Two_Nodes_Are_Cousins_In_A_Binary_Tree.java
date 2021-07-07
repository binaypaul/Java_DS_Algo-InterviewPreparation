package NonLinearDS.Tree.Problems;

import NonLinearDS.Tree.BinaryTree.BinaryTree;
import NonLinearDS.Tree.BinaryTree.CalculateDepthOfANode;
import NonLinearDS.Tree.Node;

public class Check_Two_Nodes_Are_Cousins_In_A_Binary_Tree {
    public static void main(String[] args) {
        int sortedArray[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryTree tree = new BinaryTree(sortedArray);
        Node root = tree.create();

        Node Node1, Node2;
        Node1 = root.left.left;
        Node2 = root.left.right;
        if (isCousin(root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isCousin(Node root, Node node1, Node node2) {
        if (node1 == node2)
            //if same node, return false.
            return false;
        //find left level
        int leftLevel = findLevel(root, node1);
        //find right level
        int rightLevel = findLevel(root, node2);
        if (leftLevel == rightLevel) {
            //not sibling if at same level but different parent
            boolean isSibling = isSibling(root, node1, node2);
            //if at same level but not sibling, then these are cousins.
            return !isSibling;
        }
        return false;
    }

    private static boolean isSibling(Node root, Node node1, Node node2) {
        if (root == null)
            return false;
        return ((root.left == node1 && root.right == node2) ||
                (root.left == node2 && root.right == node1)) ||
                isSibling(root.left, node1, node2) ||
                isSibling(root.right, node1, node2);
    }

    private static int findLevel(Node root, Node node) {
        return new CalculateDepthOfANode(root, node).calculateDepth();
    }


}