package Char07.S5.LeetCode429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        if (root == null) {
            return list;
        }
        //将根节点添加进队列
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = que.poll();
                //向集合中添加根节点
                levelList.add(node.val);
                //创建集合进行存储每一层的孩子节点
                List<Node> children = node.children;
                //中间出现的空值直接跳过（不写此if也可）
                if (children == null || children.size() == 0) {
                    continue;
                }
                //遍历集合 添加进队列
                for (Node child : children) {
                    if (child != null) {
                        que.offer(child);
                    }
                }
            }
            list.add(levelList);
        }

        return list;
    }


    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
