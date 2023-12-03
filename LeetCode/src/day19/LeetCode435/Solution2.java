package day19.LeetCode435;

import java.util.Arrays;

public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //将左边界从小到大排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        //排序后该题将类似为最长递增子序列
        //设dp[i]表示前i个区间中最大不重合区间的个数
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        //n减去最多的不重复的区间 就是最少删除区间的个数
        //会超时 故用贪心
        return intervals.length-Arrays.stream(dp).max().getAsInt();
    }
}
