package day01.LeetCode104;

public class Solution {
    public static void main(String[] args) {

    }

    //深度优先遍历
    public int maxDepth(TreeNode root) {
        //根节点为0 直接返回0
        if (root == null) {
            return 0;
        } else {
            //分别查询左右子树的最大深度
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            //返回最大深度+1（加上根节点）
            return Math.max(leftHeight, rightHeight) + 1;
        }
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

