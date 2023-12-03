package day37.LeetCode2583;

import java.util.*;

public class Solution {
    public List<Long> resList = new ArrayList<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //que.offer(node) 将根节点添加进去
        que.offer(root);
        //当队列不为空时进行添加操作
        while (!que.isEmpty()) {
            //创建集合进行存储每一层的节点
            long sum = 0;
            //记录每层的节点个数
            int len = que.size();

            while (len > 0) {
                //记录并删除队列中的节点
                TreeNode tmpNode = que.poll();
                sum += tmpNode.val;
                //依次判断左右子树是否为空 不为空则添加到队列

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                //节点数-1
                len--;
            }
            //返回集合
            resList.add(sum);
        }
        Collections.sort(resList);
        Collections.reverse(resList);
        if(k-1> resList.size())return 0;
        else
        return resList.get(k-1);

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
