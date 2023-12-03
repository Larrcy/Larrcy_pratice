package Char07.S6.LeetCode226;


public class Solution {
        //翻转二叉树
        //前序遍历和后序遍历可用此法
        //中序遍历要交换两次左子树才能实现
        //递归法
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            swapChildren(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        private void swapChildren(TreeNode root) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
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
