package Char07.S16.LeetCode513;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //层序遍历
    public int findBottomLeftValue(TreeNode root) {
     if(root==null) return 0;
        Queue<TreeNode>que =new LinkedList<>();
        que.offer(root);
        int res=0;
        while (!que.isEmpty()){
            int len =que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node =que.poll();
                if(i==0)res=node.val;
                if(node.left!=null)que.offer(node.left);
                if(node.right!=null)que.offer(node.right);

            }

        }
        return res;
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
