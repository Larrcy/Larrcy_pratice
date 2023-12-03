package Char07.S2.LeetCode589;

import java.util.ArrayList;
import java.util.List;
//递归 求解N叉树的前序遍历
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer>res =new ArrayList<>();
        pre(root,res);
        return res;

    }
    public void pre(Node root, List<Integer> res) {
        //若为空 则返回null
        if (root == null) {
            return;
        }
        //前序遍历 根 孩子
        //按根左右的方式递归
        res.add(root.val);
        for (int j = 0; j < root.children.size(); j++) {
            pre(root.children.get(j),res);
        }
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
