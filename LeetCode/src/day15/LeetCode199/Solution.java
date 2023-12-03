package day15.LeetCode199;

import java.util.*;

public class Solution {
    //创建集合进行存储每一层的节点
    public List<Integer> itemList = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        checkFun(root);

        return itemList;
    }

    //BFS--迭代方式--借助队列
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
                //若节点为该层最后一个节点 则节点可以被看到 故添加进集合
                if (len - 1==i) {
                    itemList.add(tmpNode.val);
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
