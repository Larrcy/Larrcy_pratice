package day81.LeetCode100123;


import java.util.Arrays;

/**
 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

 你可以对数组执行 至多 k 次操作：

 从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
 最终数组的频率分数定义为数组中众数的 频率 。

 请你返回你可以得到的 最大 频率分数。

 众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。*/
public class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] sum = new long[n + 1];
        //求nums的前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //滑动窗口进行统计能否把nums[i]变成中位数
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            //当操作次数超过k时 移动左端点缩小窗口
            while (distanceSum(nums, sum, left, i) > k) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    //计算将[l,r]内的所有元素变成中位数所需要的操作次数
    long distanceSum(int[] nums, long[] sum, int left, int right) {
        //找到中位数的下标
        int i = left + right >> 1;
        long leftSum = nums[i] * (i - left) - (sum[i] - sum[left]);
        long rightSum = sum[right + 1] - sum[i + 1] - nums[i] * (right - i);
        return leftSum + rightSum;
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














