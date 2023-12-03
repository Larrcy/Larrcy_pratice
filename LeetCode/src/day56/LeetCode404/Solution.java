package day56.LeetCode404;

public class Solution {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root);
        return sum;
    }

    void traversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }
        traversal(root.left);
        traversal(root.right);
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
