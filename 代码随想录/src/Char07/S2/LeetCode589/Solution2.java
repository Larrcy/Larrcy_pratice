package Char07.S2.LeetCode589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//迭代法 栈模拟 前序
//栈后进先出
public class Solution2 {
    public List<Integer> preorder(Node root) {
    List<Integer>res =new ArrayList<>();
    if(root==null)return res;
        Stack<Node>stack =new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node =stack.pop();
            res.add(node.val);
            for (int j = node.children.size()-1; j >=0; j--) {
                if(node.children.get(j)!=null){
                    stack.push(node.children.get(j));
                }
            }
        }
        return res;
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
