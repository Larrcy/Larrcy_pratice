package Char07.S17.LeetCode113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result= new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum (TreeNode root,int targetSum) {
        travesal(root, targetSum);
        return result;
    }
    //需要遍历整棵树 故不需要返回值
    private void travesal(TreeNode root,  int count) {
        if (root == null) return;
        //将根节点的值添加进集合(根节点一定包含在集合中)
        list.offer(root.val);
        count -= root.val;
        //遍历到最后若满足条件 则将集合添加进结果
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(list));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        //不满足条件则进行回溯
        list.removeLast();
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
