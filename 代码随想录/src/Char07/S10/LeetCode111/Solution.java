package Char07.S10.LeetCode111;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //分别查询左右子树的最大深度
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            if(root.left==null){
                return rightHeight+1;
            }
            if(root.right==null){
                return leftHeight+1;
            }

            //返回最小深度+1（加上根节点）
            return Math.min(leftHeight, rightHeight) + 1;
        }
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
