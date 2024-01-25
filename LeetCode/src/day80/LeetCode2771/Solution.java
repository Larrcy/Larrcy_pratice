package day80.LeetCode2771;

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度均为 n 。
 *
 * 让我们定义另一个下标从 0 开始、长度为 n 的整数数组，nums3 。对于范围 [0, n - 1] 的每个下标 i ，你可以将 nums1[i] 或 nums2[i] 的值赋给 nums3[i] 。
 *
 * 你的任务是使用最优策略为 nums3 赋值，以最大化 nums3 中 最长非递减子数组 的长度。
 *
 * 以整数形式表示并返回 nums3 中 最长非递减 子数组的长度。
 *
 * 注意：子数组 是数组中的一个连续非空元素序列。
 */
public class Solution {

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 1) return 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 给定一个初值，可以理解为以i处元素结尾的连续子数组的长度为1
            // 这样可以保证在i处元素都小于nums1[i-1]和nums2[i-1]时有默认值
            dp[i][0] = dp[i][1] = 1;
            // 1 当nums1[i] >= nums1[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums1[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+1);
            // 2 当nums1[i] >= nums2[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums2[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+1);
            // 3 当nums2[i] >= nums1[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums1[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+1);
            // 4 当nums2[i] >= nums2[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums2[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][1]+1);
            // 比较连续子数组的最大长度
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode pre = null;
        cur = head;
        while (n >= k) {
            n -= k;
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }

    boolean isValid(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }

    class UnionFind {
        int count;      // 连通分量个数
        int[] parent;   // 节点i的父节点是parent[i]

        public UnionFind(int N) {
            this.count = N;         // n为图的节点总数
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;      // 父节点指针初始指向自己
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;          // x成为y的子树
            count--;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

}














