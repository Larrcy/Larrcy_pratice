package Char07.S9.LeetCode559;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        //迭代模拟
        Queue<Node>que =new LinkedList<>();
        que.offer(root);
        int depth =0;
        while (!que.isEmpty()){
            depth++;
            int len =que.size();
            for (int i = 0; i < len; i++) {
                Node node = que.poll();
                for (int j = 0; j < node.children.size(); j++) {
                    if(node.children.get(j)!=null){
                        que.offer(node.children.get(j));
                    }
                }

            }

        }
        return depth;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
