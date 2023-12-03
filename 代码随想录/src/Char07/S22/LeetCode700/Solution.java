package Char07.S22.LeetCode700;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val)return root;
        TreeNode treeNode=null;
        if(root.val>val)treeNode=searchBST(root.left,val);
        if(root.val<val)treeNode=searchBST(root.right, val);
        return treeNode;

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
