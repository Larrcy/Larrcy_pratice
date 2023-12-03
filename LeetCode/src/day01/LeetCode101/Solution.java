package day01.LeetCode101;

public class Solution {

    public static void main(String[] args) {

    }

    //利用后序遍历才能实现对称二叉树的判断
    //先比较左右孩子 再比较根节点
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);

    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;
        if (right == null && left == null) return true;
        //先判断左右节点为空的情况 再判断值相等
        if (right.val != left.val) return false;
        //若左右节点值相等则进行递归
        boolean outer = false;
        boolean inside = false;
        if (right.val == left.val) {
            outer = dfs(left.left, right.right);
            inside = dfs(left.right, right.left);
        }
        return outer && inside;
    }
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
