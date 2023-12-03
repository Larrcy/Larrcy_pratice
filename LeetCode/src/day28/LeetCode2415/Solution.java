package day28.LeetCode2415;

import Char07.S6.LeetCode226.Solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (count % 2 == 1) {
                //反转该层的每一个节点的值
                List<TreeNode> nodes = new ArrayList<>(deque);
                for (int i = 0; i < nodes.size() / 2; i++) {
                    TreeNode treeNode = nodes.get(i);
                    TreeNode treeNode1 = nodes.get(nodes.size() - 1 - i);
                    int temp = treeNode.val;
                    treeNode.val = treeNode1.val;
                    treeNode1.val = temp;
                }
            }
            while (size-- > 0) {
                TreeNode node = deque.poll();

                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            count++;
        }
        return root;
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
