package Char07.S17.LeetCode112;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归法
        if(root==null)return false;
        //当遍历到叶子节点时判断 最后值是否为0
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0)return true;
        if(root.left==null&&root.right==null&&targetSum!=0)return false;
        //进行递归
        if(root.left!=null){

            //将正确的路径一层一层的返回到根节点
            if(hasPathSum(root.left,targetSum)){return true;}
            //将最后的结果再加到根节点;
        }
        if(root.right!=null){
            //将正确的路径一层一层的返回到根节点
            if(hasPathSum(root.right,targetSum)){return true;}
            //将最后的结果再加到根节点

        }
        //最后若不满足 则不存在
        return false;

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
