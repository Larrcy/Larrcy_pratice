package Char07.S15.LeetCode404;

import java.util.LinkedList;
import java.util.Queue;

//迭代法 层序遍历
public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>que =new LinkedList<>();
        que.offer(root);
        int sum =0;
        while (!que.isEmpty()){
            int len =que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node =que.poll();
                if(node.left!=null){
                    que.offer(node.left);
                    if(node.left.right==null&&node.left.left==null){
                        sum+= node.left.val;
                    }
                }
                if(node.right!=null){
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
