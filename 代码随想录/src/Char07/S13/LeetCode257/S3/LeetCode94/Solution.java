package Char07.S13.LeetCode257.S3.LeetCode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
    //中序 迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        //建立指针来指向根节点
        TreeNode cur = root;
        //当指针所指的节点不为空 或栈不为空进行循环
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                //若节点不为空 则将该节点的值入栈
                //且去寻找节点的左孩子
                stack.push(cur);
                cur = cur.left;
            }else{
                //若节点为空则进行出栈操作
                cur = stack.pop();
                //将节点添加到数组
                //出栈后返回到该节点的上一节点
                result.add(cur.val);
                //再查看右孩子是否为空
                cur = cur.right;
            }
        }
        return result;
    }
}

class TreeNode {
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
