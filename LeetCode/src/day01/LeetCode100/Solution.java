package day01.LeetCode100;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //若p q都为空则返回true
        if (p == null && q == null) {
            return true;
        }
        //比较节点
        //若两棵树一个为空 一个不为空则返回false
        //或者两个数的对应的节点值不同也返回false
        if (p != null && q == null || q != null && p == null || p.val != q.val) {
            return false;
        } else {
            //节点比较完后比较左右子树
            //若都相同则返回true
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
}

