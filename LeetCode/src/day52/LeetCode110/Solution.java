package day52.LeetCode110;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        //根节点为空返回true
        if (root == null) {
            return 0;
        }
        //高度一定是非负的若出现-1则一定不为平衡二叉树

        //左右根
        //记录左子树的高度
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        //记录右子树的高度
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //最后返回左右子树的最大高度再加1
        return Math.max(leftHeight, rightHeight) + 1;
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
