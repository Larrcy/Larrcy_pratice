package day34.LeetCode2569;

public class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        // 初始总和
        long sum = 0;
        for (int i : nums2) {
            sum += i;
        }

        // 结果的长度
        int m = 0;
        for (int[] query : queries) {
            if (query[0] == 3) {
                m++;
            }
        }
        long[] ans = new long[m];

        // 构建树
        int length = nums1.length;
        cnt1 = new int[length << 2];
        lazy = new boolean[length << 2];
        build(nums1);

        // 结果数组的索引
        int i = 0;
        //遍历指令
        for (int[] query : queries) {
            if (query[0] == 1) {
                update(query[1], query[2], length - 1);
            } else if (query[0] == 2) {
                sum += (long) query[1] * cnt1[0];
            } else {
                ans[i++] = sum;
            }
        }

        return ans;
    }

    // 计数1
    private int[] cnt1;
    // 懒惰
    private boolean[] lazy;

    private void build(int[] a) {
        doBuild(a, 0, 0, a.length - 1);
    }

    private void doBuild(int[] a, int k, int l, int r) {
        if (l == r) {
            // 叶子结点
            cnt1[k] = a[l];
            return;
        }
        // 非叶子结点
        int m = l + (r - l) / 2;
        doBuild(a, 2 * k + 1, l, m);
        doBuild(a, 2 * k + 2, m + 1, r);
        pushUp(k);
    }

    /**
     * 这个方法决定了线段树存储的是什么，很重要
     *
     * @param k cnt1的下标
     */
    private void pushUp(int k) {
        cnt1[k] = cnt1[2 * k + 1] + cnt1[2 * k + 2];
    }

    private void pushDown(int k, int l, int r) {
        if (lazy[k]) {
            int m = l + (r - l) / 2;
            // 更新左区间
            reverse(2 * k + 1, l, m);
            // 更新右区间
            reverse(2 * k + 2, m + 1, r);
            // 消除标记
            lazy[k] = false;
        }
    }

    private void update(int ll, int rr, int r) {
        doUpdate(0, 0, r, ll, rr);
    }

    private void reverse(int k, int l, int r) {
        cnt1[k] = r - l + 1 - cnt1[k];
        // 如果两次操作的子操作区间范围一样，则两次抵消，即false->true->false，不可以更新左右区间的值，否则会出错
        // nums1：[0,1,0,0,0,0]
        // nums2：[14,4,13,13,47,18]
        // queries：[[3,0,0],[1,4,4],[1,1,4],[1,3,4],[3,0,0],[2,5,0],[1,1,3],[2,16,0],[2,10,0],[3,0,0],[3,0,0],[2,6,0]]
        // 错误解：[109,109,145,145]
        // 正确解：[109,109,197,197]
        lazy[k] = !lazy[k];
    }

    private void doUpdate(int k, int l, int r, int ll, int rr) {
        if (ll <= l && rr >= r) {
            // 真子集
            reverse(k, l, r);
            return;
        }
        pushDown(k, l, r);
        int m = l + (r - l) / 2;
        if (ll <= m) {
            // 左半区有交集
            doUpdate(2 * k + 1, l, m, ll, rr);
        }
        if (rr > m) {
            // 右半区有交集
            doUpdate(2 * k + 2, m + 1, r, ll, rr);
        }
        // 更新父节点值
        pushUp(k);
    }

}
