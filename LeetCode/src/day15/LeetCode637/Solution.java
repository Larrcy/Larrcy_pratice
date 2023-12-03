package day15.LeetCode637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> itemList = new ArrayList<Double>();

    public List<Double> averageOfLevels(TreeNode root) {
        checkFun(root);
        return itemList;
    }

    public void checkFun(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //que.offer(node) 将根节点添加进去
        que.offer(node);
        //当队列不为空时进行添加操作
        while (!que.isEmpty()) {
            //记录每层的节点个数
            int len = que.size();
            //记录每层节点的循环次数
            double sum = 0;
            for (int i = 0; i < len; i++) {
                //记录并删除队列中的节点
                TreeNode tmpNode = que.poll();
                //依次判断左右子树是否为空 不为空则添加到队列
                //顺序不可颠倒
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }

                sum += tmpNode.val;
                //若节点为该层最后一个节点
                //则计算平均值
                if (len - 1 == i) {
                    itemList.add(sum / len);
                }
            }
        }
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

