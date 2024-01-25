package day81.LeetCode2100;


import java.util.ArrayList;
import java.util.List;

/**
 * 你和朋友们准备去野炊。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天的建议出行指数。日子从 0 开始编号。同时给你一个整数 time 。
 * <p>
 * 如果第 i 天满足以下所有条件，我们称它为一个适合野炊的日子：
 * <p>
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天建议出行指数都是非递增的。
 * 第 i 天后连续 time 天建议出行指数都是非递减的。
 * 更正式的，第 i 天是一个适合野炊的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 * <p>
 * 请你返回一个数组，包含 所有 适合野炊的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 */
public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //设第 i 天前建议出行指数连续非递增的天数为left[i]
        //第 i 天后建议出行指数连续非递减的天数为 right[i]
        //当第 i 天同时满足 left[i]≥time,right[i]≥time 时，第 i 天适合野炊。
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            //若security[i] <= security[i - 1]
            //此时满足第i天前的security连续非递增
            //故left[i]=left[i-1]+1
            //若security[i] > security[i - 1]
            //此时前i天不满足security连续非递增left[i]=0
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            //同理可从右向左判断right[i]
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }
        //收集结果
        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
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














