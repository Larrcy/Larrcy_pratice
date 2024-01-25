package 模板.线段树.LeetCode2426;

/**
 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, j) ：

 0 <= i < j <= n - 1 且
 nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
 请你返回满足条件的 数对数目 。


 */
public class Solution {
    //线段树解决的是「区间和」的问题，且该「区间」会被修改
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        // 偏移量
        int move = 3 * (int) 1e4;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // d 为更新量，target 为查询量
            int d = nums1[i] - nums2[i];
            int target = d + diff;
            // 查询区间 [0, target + move] 上的数量
            ans += query(root, 0, N, 0, target + move);
            // 更新区间 [d + move, d + move]
            update(root, 0, N, d + move, d + move, 1);
        }
        return ans;
    }
    // *************** 下面是模版 ***************
    class Node {
        Node left, right;
        int val, add;
    }
    private int N = (int) 1e9;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += (end - start + 1) * val;
            node.add += val;
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
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
}




