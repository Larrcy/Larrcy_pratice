package day02.LeetCode112;

public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //树为空 直接返回false
        if (root == null) {
            return false;
        }
        //若左子树和右子树均为空
        //则根节点的值为唯一值
        //若为叶子节点则比较是否叶子节点满足最后扣除后的值
        //进行比较
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        //其他情况 运用递归遍历树的每一条路径
        //遍历左子树或者右子树
        //运用递归将问题进行简化是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val
        //一直递归下去直到找到最后一个根节点的值
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    class TreeNode {
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
