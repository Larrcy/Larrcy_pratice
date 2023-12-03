package day02.LeetCode110;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //若左右子树有一个不平衡也不满足条件
        if(!isBalanced(root.left)||!isBalanced(root.right)){
            return false;
        }
        //若左右子树的高度差大于1则不满足条件
        if (Math.abs(getHeight(root.right) - getHeight(root.left)) > 1) {
            return false;
        }
        //排除上述情况则二叉树平衡
        return true;

    }

    //求树的高度
    public int getHeight(TreeNode root) {
        return root == null ? 0 :Math.max(getHeight(root.left),getHeight(root.right))+1;
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