package Char07.S13.LeetCode257.S3.LeetCode145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
        //将前序遍历的左右子树入栈顺序颠倒最后再反转结果集即可
        class Solution {
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> result = new ArrayList<>();
                if (root == null) {
                    return result;
                }
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    result.add(node.val);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
                Collections.reverse(result);
                return result;
            }

        }
    }
}

