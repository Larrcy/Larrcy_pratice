package day56.LeetCode971;

import java.util.*;

public class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // 遍历的过程中尝试进行反转
        traverse(root, voyage);
        if (canFlip) {
            return res;
        }
        return Arrays.asList(-1);
    }

    List<Integer> res = new LinkedList<>();
    int i = 0;
    boolean canFlip = true;

    void traverse(TreeNode root, int[] voyage) {
        if (root == null || !canFlip) {
            return;
        }
        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            res.add(root.val);
        }
        traverse(root.left,voyage);
        traverse(root.right,voyage);
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
