package NonLinearDS.Tree.BinaryTree;

import NonLinearDS.Tree.Node;
import NonLinearDS.Tree.Search.BFS_or_LevelOrderTraversal;

public class TreeClassesTester {
    public static void main(String[] args) {
        int sortedArray[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node root = new BinaryTree(sortedArray).create();
        new BFS_or_LevelOrderTraversal(root).printLevelOrder();
    }
}
