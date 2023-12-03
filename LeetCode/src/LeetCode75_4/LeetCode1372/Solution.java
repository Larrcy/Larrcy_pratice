package LeetCode75_4.LeetCode1372;

public class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root ==null)return max;
        helper(root,0,true);
        helper(root,0,false);
        return max;
    }

    private void helper(TreeNode node,int length,boolean isLeft){
        if(node == null)return;
        if(isLeft) {
            //若为左节点 向下递归时右节点的length+1 为保证交替进行isLeft变为false
            helper(node.right,length+1,false);
            //左节点的长度重新变为1为下次递归做准备
            helper(node.left,1,true);
        }else{
            helper(node.left,length+1,true);
            helper(node.right,1,false);
        }
        if(length > max) max = length;
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


