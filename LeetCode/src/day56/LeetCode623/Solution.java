package day56.LeetCode623;

public class Solution {
    int curDepth = 0;
   int targetVal, targetDepth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        targetVal = val;
        targetDepth = depth;
        // 插入到第一行的话特殊对待一下
        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(targetVal);
            newRoot.left = root;
            return newRoot;
        }
        // 遍历二叉树，走到对应行进行插入
        traversal(root);

        return root;
    }

    void traversal(TreeNode root) {
        if(root==null)return;
        curDepth++;
        if(curDepth==targetDepth-1){
            // 进行插入
            TreeNode newLeft = new TreeNode(targetVal);
            TreeNode newRight = new TreeNode(targetVal);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }
        traversal(root.left);
        traversal(root.right);
        // 后序遍历
        curDepth--;
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
