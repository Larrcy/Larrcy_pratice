package 基础算法.线段树.LeetCode307;

/**
 给你一个数组 nums ，请你完成两类查询。

 其中一类查询要求 更新 数组 nums 下标对应的值
 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 实现 NumArray 类：

 NumArray(int[] nums) 用整数数组 nums 初始化对象
 void update(int index, int val) 将 nums[index] 的值 更新 为 val
 int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）


 */
public class Solution {
    public void NumArray(int[] nums) {
        N = nums.length - 1;
        for (int i = 0; i <= N; i++) {
            update(root, 0, N, i, i, nums[i]);
        }
    }

    public void update(int index, int val) {
        update(root, 0, N, index, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, 0, N, left, right);
    }

    class Node {
        // 左右孩子节点
        Node left, right;
        // 当前节点值，以及懒惰标记的值
        int val, add;
    }
    private int N;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val = (end - start + 1) * val;
            node.add = val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans += query(node.left, start, mid, l, r);
        if (r > mid) ans += query(node.right, mid + 1, end, l, r);
        return ans;
    }
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val = node.add * leftNum;
        node.right.val = node.add * rightNum;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
}




