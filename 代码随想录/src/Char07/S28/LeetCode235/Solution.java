package Char07.S28.LeetCode235;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            //根节点比左右都大则一定在左子树
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            //根节点比左右都小则一定在右子树
            return lowestCommonAncestor(root.right, p, q);
        //若一个比根节点大 一个比根节点小则一定在根节点
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
