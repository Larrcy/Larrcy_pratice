package day48.LeetCode965;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return uniVal(root, root.val);
    }

    public boolean uniVal(TreeNode t, int val) {
        if (t == null) {
            return true;
        }
        if (t.val != val) {
            return false;
        }
        return uniVal(t.left, val) && uniVal(t.right, val);
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
