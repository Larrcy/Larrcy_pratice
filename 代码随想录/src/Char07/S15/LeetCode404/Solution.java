package Char07.S15.LeetCode404;

//左叶子节点之和
//后序遍历 递归实现
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null) return 0;
        //遍历左子树
        int leftNum =sumOfLeftLeaves(root.left);
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            leftNum = root.left.val;
        }
        //遍历右子树节点 再由上面的递归进行判断
        int rightNum =sumOfLeftLeaves(root.right);
        return rightNum+leftNum;

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
