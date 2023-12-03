package day52.LeetCode1026;

public class Solution {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int mn, int mx) {
        if (node == null) return;
      //记录递归路径中的最小值和最大值
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        //答案即为最大值与最小值与node的差值
        ans = Math.max(ans, Math.max(node.val - mn, mx - node.val));
        dfs(node.left, mn, mx);
        dfs(node.right, mn, mx);
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
