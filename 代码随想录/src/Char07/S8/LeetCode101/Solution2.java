package Char07.S8.LeetCode101;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

     //迭代法使用普通队列

    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        //将左节点和右节点添加到队列进行判断
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            //将队列的节点出栈并判断是否相等
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            //此时是对称的情况
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null && rightNode != null) {
                return false;
            }
            if (leftNode != null && rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            //将左节点的左孩子与右节点的右孩子添加进队列
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            //将左节点的有孩子和右节点的左孩子添加进队列
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }

}
