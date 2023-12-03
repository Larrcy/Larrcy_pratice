package day52.LeetCode199;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
//先放根节点再放右子树 右子树放完再放左子树
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        //刚开始depth为0放根节点
        if (depth == ans.size())
            ans.add(root.val);
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

  public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
