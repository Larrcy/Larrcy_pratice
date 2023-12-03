package day67.LeetCode2641;

import java.util.ArrayList;

/**
 给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。

 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。

 请你返回修改值之后，树的根 root 。

 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            //将该层的所有节点都放到tmp中去
            ArrayList<TreeNode> tmp = q;
            q = new ArrayList<>();
            int nextLevelSum = 0; // 下一层的节点值之和
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    q.add(node.left);
                    nextLevelSum += node.left.val;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextLevelSum += node.right.val;
                }
            }

            // 再次遍历，更新下一层的节点值
            for (TreeNode node : tmp) {
                int childrenSum = (node.left != null ? node.left.val : 0) +
                        (node.right != null ? node.right.val : 0);
                if (node.left != null) node.left.val = nextLevelSum - childrenSum;
                if (node.right != null) node.right.val = nextLevelSum - childrenSum;
            }
        }
        return root;
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
