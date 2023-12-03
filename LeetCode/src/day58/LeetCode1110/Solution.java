package day58.LeetCode1110;
import java.util.*;
public class Solution {
    Set<Integer> delSet = new HashSet<>();
    // 记录森林的根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return res;
        for (int d : to_delete) {
            delSet.add(d);
        }
        doDelete(root, false);
        return res;
    }

    // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
    private TreeNode doDelete(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }
        // 判断是否需要被删除
        boolean deleted = delSet.contains(root.val);
        if (!deleted && !hasParent) {
            // 没有父节点且不需要被删除，就是一个新的根节点
            res.add(root);
        }
        // 去左右子树进行删除
        root.left = doDelete(root.left, !deleted);
        root.right = doDelete(root.right, !deleted);
        // 如果需要被删除，返回 null 给父节点
        return deleted ? null : root;
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
