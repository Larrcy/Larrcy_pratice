package Char07.S23.LeetCode98;

public class Solution {
    TreeNode pre =null;
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        //定义指针来实现当前节点与上一个节点的值进行比较
        pre = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
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
