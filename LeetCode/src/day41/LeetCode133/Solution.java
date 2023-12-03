package day41.LeetCode133;

import java.util.*;

public class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return node;
       Queue<Node>queue =new LinkedList<>();
        HashMap<Node, Node> visited = new HashMap();
       queue.add(node);
      visited.put(node,new Node(node.val,new ArrayList<>()));
       while (!queue.isEmpty()){
           Node cur =queue.poll();
           for (Node next : cur.neighbors) {
               if(!visited.containsKey(next)){
                   visited.put(next,new Node(next.val,new ArrayList<>()));
                   queue.add(next);
               }
               visited.get(cur).neighbors.add(visited.get(next));
           }
       }
       return visited.get(node);

    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
