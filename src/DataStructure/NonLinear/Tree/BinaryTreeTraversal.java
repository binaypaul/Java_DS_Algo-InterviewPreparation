package DataStructure.Tree;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		//Binary Tree
		//level 1
		TreeNode root = new TreeNode(55);
		root.left = new TreeNode(33);
		root.right = new TreeNode(77);
		//
		
		//level 2
		root.left.left = new TreeNode(22);
		root.left.right = new TreeNode(44);
		root.right.left = new TreeNode(66);
		root.right.right = new TreeNode(88);
		//
		BTT btt = new BTT();
		btt.printInOrder(root);
		System.out.println();
		btt.printPreOrder(root);
		System.out.println();
		btt.printPostOrder(root);
	}
}

class BTT {	
	//Inorder traversal (Left -> Root -> Right)
	public void printInOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}
	
	//Preorder traversal (Root -> Left -> Right)
	public void printPreOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	//Postorder traversal (Left -> Right -> Root)
	public void printPostOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}
}