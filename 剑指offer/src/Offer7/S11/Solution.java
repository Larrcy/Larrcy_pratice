package Offer7.S11;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //中序遍历用集合进行存储
    List<Integer> res = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        traversal(root);
        return res.get(res.size()-k);
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
