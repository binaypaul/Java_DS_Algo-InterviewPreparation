package DataStructure.Neetcode150.G_Tree;

import DataStructure.Neetcode150.G_Tree.Concept.BST.TreeNode;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
/**
 * NOTE: In-order DFS Traversal prints a BST in smallest-to-largest order.
 */
public class m_Kth_Smallest_Element_In_A_BST_DFS {
    private int count = 0;
    private int resElem = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderDfs(root, k);
        return resElem;
    }

    private void inorderDfs(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        if(count != k)
            inorderDfs(root.left, k);

        if(++count == k) {
            resElem = root.val;
            return;
        }
        if(count != k)
            inorderDfs(root.right, k);
    }

    public static void main(String[] args) {
        System.out.println(
                new m_Kth_Smallest_Element_In_A_BST_DFS()
                .kthSmallest(TreeNode.create(5,3,6,2,4,null,null,1), 3)
        );
    }
}
