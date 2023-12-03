package Char07.S25.LeetCode501;

public class Solution2 {
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //中序遍历的倒序的二叉搜索树为递减的排列
        traversal(root.right);
        if (k == 0) return;
        k--;
        res = root.val;
        traversal(root.left);

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
