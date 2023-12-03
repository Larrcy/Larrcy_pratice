package Char07.S2.LeetCode145;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    //后序遍历
    public void postorder(TreeNode root, List<Integer> res) {
        //若为空 则返回null
        if (root == null) {
            return;
        }
        //后序遍历 根左右
        //按左右根的方式递归
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);

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