package Char07.S5.LeetCode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);

        return resList;
    }
    //BFS--迭代方式--借助队列
    public void checkFun(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //que.offer(node) 将根节点添加进去
        que.offer(node);
        //当队列不为空时进行添加操作
        while (!que.isEmpty()) {
            //创建集合进行存储每一层的节点
            List<Integer> itemList = new ArrayList<Integer>();
            //记录每层的节点个数
            int len = que.size();

            while (len > 0) {
                //记录并删除队列中的节点
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);
                //依次判断左右子树是否为空 不为空则添加到队列

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                //节点数-1
                len--;
            }
            //返回集合
            resList.add(itemList);
        }
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
