package Char07.S21.LeetCode617;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //将合并后的二叉树合并到root1上节省空间
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //前序遍历 中左右
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
