package DataStructure.Neetcode150.G_Tree.Concept.BST;

public class BST {

    //Create a BST
    public static TreeNode createBST(Integer[] values) {
        TreeNode root = null;
        for (Integer value : values) {
            if(value != null)
                root = insert(root, value);
        }
        return root;
    }

    //Add a node
    public static TreeNode insert(TreeNode root, Integer value) {
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
    public static TreeNode remove(TreeNode root, Integer value) {
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
    public static boolean search(TreeNode root, Integer value) {
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
    public static TreeNode findMin(TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null)
            return root;
        else {
            return findMin(root.left);
        }
    }
}
