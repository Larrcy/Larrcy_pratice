package day56.LeetCode257;

import java.util.*;

public class Solution {
    // 记录 traverse 函数递归时的路径
    LinkedList<String> path = new LinkedList<>();
    // 记录所有从根节点到叶子节点的路径
    LinkedList<String> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) return;
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            res.addLast(String.join("->", path));
        }
        traversal(root.left);
        traversal(root.right);
        path.removeLast();
    }


    public class TreeNode {
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
}
