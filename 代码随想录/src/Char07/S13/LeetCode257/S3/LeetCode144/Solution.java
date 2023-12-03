package Char07.S13.LeetCode257.S3.LeetCode144;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    //前序遍历
    //递归法
    public void preorder(TreeNode root, List<Integer> res) {
        //若为空 则返回null
        if (root == null) {
            return;
        }
        //前序遍历 根左右
        //按根左右的方式递归
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
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
