package Char10.S31.LeetCode337;

public class Solution {



    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction1(TreeNode root) {
        //定义res 有两个状态
        //res0表示偷当前节点
        //res1表示不偷当前节点
        int res[] = new int[2];
        if (root == null)
            return res;
        //后序遍历 由下往上推
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
        res[0] = root.val + left[1] + right[1];
        // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
        // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
        // Math.max(rob(root.right)[0], rob(root.right)[1])
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
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
