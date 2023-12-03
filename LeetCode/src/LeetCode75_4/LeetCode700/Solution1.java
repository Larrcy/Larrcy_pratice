package LeetCode75_4.LeetCode700;

import java.util.ResourceBundle;

public class Solution1 {
    public TreeNode searchBST(TreeNode root, int val) {
        //递归法
        if(root==null||root.val==val)return root;
        TreeNode treeNode =null;
        if(val< root.val)treeNode=searchBST(root.left,val);
        if(val> root.val)treeNode=searchBST(root.right,val);
        return treeNode;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
