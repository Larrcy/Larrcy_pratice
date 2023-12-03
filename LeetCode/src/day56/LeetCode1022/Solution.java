package day56.LeetCode1022;

public class Solution {
    int res = 0;
    int sb=0;

    public int sumRootToLeaf(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            res += sb * 2 + root.val;
        }
        sb=sb*2+root.val;
        traversal(root.left);
        traversal(root.right);
        sb -= root.val;
        sb /= 2;
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

