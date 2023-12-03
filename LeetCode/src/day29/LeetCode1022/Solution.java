package day29.LeetCode1022;

public class Solution {
    int ans;

    public int sumRootToLeaf(TreeNode root) {
        findSum(0, root);
        return ans;
    }

    public void findSum(int sum, TreeNode t) {
        if (t.left == null && t.right == null) {
            ans += sum * 2 + t.val;
        } else {
            if (t.left != null) {
                findSum(2 * sum + t.val, t.left);
            }
            if (t.right != null) {
                findSum(2 * sum + t.val, t.right);
            }
        }
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
