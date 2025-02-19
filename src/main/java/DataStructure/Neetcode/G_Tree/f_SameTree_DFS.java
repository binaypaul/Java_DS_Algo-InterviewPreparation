package DataStructure.Neetcode.G_Tree;

import DataStructure.Neetcode.G_Tree.Concept.TreeNode;

public class f_SameTree_DFS {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null & q == null)
            return true;
        else if((p == null & q != null) || (p != null & q == null)) {
            return false;
        } else if (p != null & q != null & p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.create(1,2,3);
        TreeNode root2 = TreeNode.create(1,2,3);
        System.out.println(root1);
        System.out.println(root2);
        System.out.println(new f_SameTree_DFS().isSameTree(root1, root2));


        TreeNode root3 = TreeNode.create(1,2);
        TreeNode root4 = TreeNode.create(1,null,2);
        System.out.println(root3);
        System.out.println(root4);
        System.out.println(new f_SameTree_DFS().isSameTree(root3, root4));


        TreeNode root5 = TreeNode.create(1,2,1);
        TreeNode root6 = TreeNode.create(1,1,2);
        System.out.println(root5);
        System.out.println(root6);
        System.out.println(new f_SameTree_DFS().isSameTree(root5, root6));
    }
}
