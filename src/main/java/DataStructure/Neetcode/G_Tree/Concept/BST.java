package DataStructure.Neetcode.G_Tree.Concept;

public class BST {

    //Create a BST
    public TreeNode createBST(int[] values) {

        TreeNode root = new TreeNode(values[0]);
        for (int i=1; i < values.length; i++) {
            insert(root, values[i]);
        }
        return root;
    }

    //Add a node
    public TreeNode insert(TreeNode root, int value) {
        if(null == root) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    //Remove a node
    public TreeNode remove(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if(value > root.val) {
            root.right = remove(root.right, value);
        } else if(value < root.val) {
            root.left = remove(root.left, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minInRightSubTree = findMin(root.right);
                root.val = minInRightSubTree.val;
                root.right = remove(root.right, minInRightSubTree.val);
            }
        }
        return root;
    }

    //Search for a node
    public boolean search(TreeNode root, int value) {
        if(root == null) {
            return false;
        }

        if(value < root.val) {
            return search(root.left, value);
        } else if (value > root.val) {
            return search(root.right, value);
        } else {
            return true;
        }
    }

    //helpers
    public TreeNode findMin(TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null)
            return root;
        else {
            return findMin(root.left);
        }
    }
}
