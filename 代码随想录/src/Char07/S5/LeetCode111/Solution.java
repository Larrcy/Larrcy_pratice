package Char07.S5.LeetCode111;

public class Solution {
    public static void main(String[] args) {

    }

    //深度优先遍历
    public int minDepth(TreeNode root) {
        //根节点为0 直接返回0
        if (root == null) {
            return 0;
        } else {
            //分别查询左右子树的最小深度
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            if (leftHeight == 0) {
                return rightHeight + 1;
            }
            if (rightHeight == 0) {
                return leftHeight + 1;
            }
            //返回最小深度+1（加上根节点）
            return Math.min(leftHeight, rightHeight) + 1;
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

