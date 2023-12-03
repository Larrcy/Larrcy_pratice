package day53.LeetCode1315;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;//孙子结点的和
        if (root == null) return 0;
        //判断是不是偶数
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) sum += root.left.left.val;
                if (root.left.right != null) sum += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null) sum += root.right.left.val;
                if (root.right.right != null) sum += root.right.right.val;
            }
        }
        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
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
