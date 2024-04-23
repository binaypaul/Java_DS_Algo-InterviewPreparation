package DataStructure.Tree;

import java.util.Arrays;

//Not working.

public class ConstructBinaryTreeFromSortedArray {
	private TreeNode root;
	
	public ConstructBinaryTreeFromSortedArray(int ...arr) {
		if(arr.length > 0)
			root = insertNode(arr);
	}
	public TreeNode getRoot() {
		return root;
	}
	
	private TreeNode insertNode(int[] arr) {
			int first = 0, last = arr.length-1;
			int middle = (first+last)%2==1 ? ((first+last)/2)+1 : (first+last)/2; //need to fix this logic.
			System.out.println("middle: " + arr[middle]);
			TreeNode root = new TreeNode(arr[middle]);
			while (arr.length > 1) {
				int[] leftArr = Arrays.copyOfRange(arr, first, middle);
				root.left = insertNode(leftArr);
				int[] rightArr = Arrays.copyOfRange(arr, middle+1, last+1);
				root.right = insertNode(rightArr);
			}
		return root;
	}
}
