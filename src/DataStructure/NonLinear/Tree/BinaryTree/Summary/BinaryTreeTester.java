package NonLinearDS.Tree.BinaryTree.Summary;

public class BinaryTreeTester {
    public static void main(String[] args) {
        int[] sortedArray =  new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryTreeUtil binaryTreeUtil = new BinaryTreeUtilImpl();
        BinaryTree binaryTree = binaryTreeUtil.createBinaryTree(sortedArray);
        System.out.println("Height: " + binaryTreeUtil.heightOfNode(binaryTree.root.left));
        System.out.println("Depth: " + binaryTreeUtil.depthOfNode(binaryTree.root, binaryTree.root.right.left));
        System.out.println("Level order:"); binaryTreeUtil.levelOrderTraversalBFS(binaryTree.root);
        System.out.println("\nInorder: "); binaryTreeUtil.inOrderTraversalDFS(binaryTree.root);
        System.out.println("\nPreorder: "); binaryTreeUtil.preOrderTraversalDFS(binaryTree.root);
        System.out.println("\nPostorder: "); binaryTreeUtil.postOrderTraversalDFS(binaryTree.root);
    }
}
