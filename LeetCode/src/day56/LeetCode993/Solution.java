package day56.LeetCode993;

public class Solution {
    TreeNode xParent, yParent;
    int xDeep, yDeep;

    public boolean isCousins(TreeNode root, int x, int y) {
        traversal(root, 0, null, x, y);
        return xDeep == yDeep && xParent != yParent;
    }

    void traversal(TreeNode node, int deep, TreeNode parent, int x, int y) {
        if (node == null) return;
        if (node.val == x) {
            xParent = parent;
            xDeep = deep;
        } else if (node.val == y) {
            yParent = parent;
            yDeep = deep;
        }
        traversal(node.left, deep + 1, node, x, y);
        traversal(node.right, deep + 1, node, x, y);
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
