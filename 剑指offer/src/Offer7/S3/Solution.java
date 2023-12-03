package Offer7.S3;

import java.util.*;

public class Solution {


    public List<List<Integer>> levelOrder(TreeNode root) {
        //创建集合存储结果
        List<List<Integer>> itemRes = new ArrayList<>();
        if (root == null) return itemRes;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int index = 0;
        while (!que.isEmpty()) {
            //创建集合存储每层节点数
            List<Integer> res = new ArrayList<>();

            //记录每层的节点数
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                res.add(node.val);

                //依次判断该节点下的左右孩子是否为空 不为空则添加进队列
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (index % 2 == 0) {
                itemRes.add(res);

            } else {
                Collections.reverse(res);
                itemRes.add(res);
            }
            index++;

        }
        return itemRes;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
