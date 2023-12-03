package Char07.S11.LeetCode222;

public class Solution3 {

      //针对完全二叉树的解法
      //满二叉树的结点数为：2^depth - 1
    //将满二叉树的情况排除后用后序遍历计算节点数

    public int countNodes(TreeNode root) {
        //节点为空的情况
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 这里初始为0是有目的的，为了下面求指数方便
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        //满二叉树的情况
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        //后序递归遍历节点数
        return countNodes(root.left) + countNodes(root.right) + 1;
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
