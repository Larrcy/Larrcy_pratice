package day33.LeetCode1337;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length; // 获取二维数组的行数
        int n = mat[0].length; // 获取二维数组的列数

        //大顶堆
        // 创建一个优先队列，并根据士兵数量和行索引对数组进行排序
        // 士兵数量多的排在前面，若士兵数量相同，则行索引大的排在前面
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        // 遍历每一行
        for (int i = 0; i < m; i++) {
            int l = 0, r = n -1;
            // 二分查找，找出当前行中最后一个士兵的位置
            while (l < r) {
                int mid = (l+r)/ 2;
                if (mat[i][mid] == 1) l = mid+1;
                else r = mid;
            }

            // 计算当前行中士兵的数
            //看最后一个士兵是否也为1
            int cur = mat[i][l] == 1 ? l + 1: l;

            // 如果优先队列已满，并且当前行的士兵数量小于队列中的最大值，弹出队列中的最大值
            if (q.size() == k && q.peek()[0] > cur) q.poll();

            // 将当前行的士兵数量和行索引加入优先队列
            if (q.size() < k) q.add(new int[]{cur, i});
        }

        // 创建结果数组，将优先队列中的行索引从后往前依次存入结果数组
        int[] ans = new int[k];
        int idx = k - 1;
        while (!q.isEmpty()) ans[idx--] = q.poll()[1];

        return ans;
    }
}
