package day16.LeetCode116;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
      checkFun(root);
      return  root;

    }

    public void checkFun(Node node) {
        if (node == null) return;
        Queue<Node> que = new LinkedList<Node>();
        //que.offer(node) 将根节点添加进去
        que.offer(node);
        //当队列不为空时进行添加操作
        while (!que.isEmpty()) {
            //记录每层的节点个数
            int len = que.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < len; i++) {
                // 从队首取出元素
                Node tmpNode = que.poll();
                //将每一层的节点进行连接 终点为null
                if (i < len - 1) {
                    //若队列为空 利用peek 可以让node指向null
                    tmpNode.next = que.peek();
                }
                // 拓展下一层节点
                if (tmpNode.left != null) {
                    que.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.add(tmpNode.right);
                }
            }
        }
    }

        class Node {
            public int val;
            public Node left;
            public Node right;
            public Node next;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }
    }

