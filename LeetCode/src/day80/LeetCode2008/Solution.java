package day80.LeetCode2008;

import java.util.ArrayList;
import java.util.List;

/**
 * 你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
 * <p>
 * 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
 * <p>
 * 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
 * <p>
 * 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
 * <p>
 * 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
 */
public class Solution {
    //动态规划 考虑最后一个乘客之前的状态
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] groups = new List[n + 1];
        for (int[] ride : rides) {
            int start = ride[0];
            int end = ride[1];
            int tips = ride[2];
            if (groups[end].isEmpty()) {
                groups[end] = new ArrayList<>();
            }
            groups[end].add(new int[]{start, end - start + tips});

        }
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (groups[i] != null) {
                for (int[] g : groups[i]) {
                    dp[i] = Math.max(dp[i], dp[g[0]] + g[1]);
                }
            }
        }
        return dp[n];
    }
}
