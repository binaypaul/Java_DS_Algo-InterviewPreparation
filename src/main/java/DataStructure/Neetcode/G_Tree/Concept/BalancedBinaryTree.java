package DataStructure.Neetcode.G_Tree.Concept;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));

        System.out.println(new BalancedBinaryTree().isBalanced(root1));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int lh = getHeight(root);
        int rh = getHeight(root);
        int hdiff = Math.abs(lh-rh);
        if (hdiff > 1) {
            return false;
        }
        if(!isBalanced(root.left)) {
            return false;
        }
        if(!isBalanced(root.right)) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }
}