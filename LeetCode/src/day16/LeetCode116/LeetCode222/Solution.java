package day16.LeetCode116.LeetCode222;

import java.util.LinkedList;
import java.util.Queue;
//层序遍历
public class Solution {
    public int countNodes(TreeNode root) {
        int sum =0;
        if(root==null)return sum;
        Queue<TreeNode>que =new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int len =que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node =que.poll();
                sum++;
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null) {
                que.offer(node.right);
                }
                }
            }
        return sum;
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
