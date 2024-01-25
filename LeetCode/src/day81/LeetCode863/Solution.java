package day81.LeetCode863;

import com.sun.org.apache.bcel.internal.generic.NOP;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
 * <p>
 * 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
 */
public class Solution {
    //以target为中心点进行bfs扩散
    //每扩散一圈distance+1直到出现distance==k时
    //将这些点进行收集即为结果
    //用map来记录每个节点的父节点
    //相当于每个节点向其左右节点以及父节点进行扩散
    Map<Integer, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traversal(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        //防止在扩散过程中节点重复访问
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int distance = 0;
        set.add(target.val);
        queue.add(target);
        //BFS-- 剪枝 distance>k时必没有满足条件的结果之间跳出循环
        while (!queue.isEmpty()&&distance<=k) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                //distance==k时收集结果
                if (distance == k) {
                    res.add(node.val);
                }
                //获取当前节点的父节点
                TreeNode parentNode = map.get(node.val);
                //BFS访问三个节点
                if (parentNode != null && !set.contains(parentNode.val)) {
                    set.add(parentNode.val);
                    queue.add(parentNode);
                }
                if (node.left != null && !set.contains(node.left.val)) {
                    set.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null && !set.contains(node.right.val)) {
                    set.add(node.right.val);
                    queue.add(node.right);
                }

            }
            //扩散完一圈distance+1
            distance++;
        }
        return res;
    }

    //存储每个节点的父节点
    void traversal(TreeNode root, TreeNode parentNode) {
        if (root == null) return;
        map.put(root.val, parentNode);
        traversal(root.left, root);
        traversal(root.right, root);
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
