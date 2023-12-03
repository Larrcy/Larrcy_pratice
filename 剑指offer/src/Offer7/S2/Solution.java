package Offer7.S2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //创建集合存储结果
        List<List<Integer>>itemRes =new ArrayList<>();
        if(root ==null ) return itemRes;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()){
            //创建集合存储每层节点数
            List<Integer> res =new ArrayList<>();
            //记录每层的节点数
            int len =que.size();
            for(int i =0;i<len;i++){
                TreeNode node =que.poll();
                res.add(node.val);

                //依次判断该节点下的左右孩子是否为空 不为空则添加进队列
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
            itemRes.add(res);

        }
        return itemRes;


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
