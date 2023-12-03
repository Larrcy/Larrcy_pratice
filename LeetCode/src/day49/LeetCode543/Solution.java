package day49.LeetCode543;

public class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans ;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R); // 将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(L, R)+1; // 返回该节点为根的子树的深度
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
