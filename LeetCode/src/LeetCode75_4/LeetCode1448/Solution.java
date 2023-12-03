package LeetCode75_4.LeetCode1448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return ans;
    }

    int ans = 0;//统计满足题意的节点数
    void dfs(TreeNode node, int curMax) {
        //节点为空直接返回
        if (node == null) return;

        //当节点值大于
        //前序遍历 根左右
        if (node.val >= curMax) {
            ans++;
            curMax = node.val;
        }
        dfs(node.left, curMax);

        dfs(node.right, curMax);
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
