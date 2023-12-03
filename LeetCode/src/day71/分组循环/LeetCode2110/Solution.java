package day71.分组循环.LeetCode2110;

/**
 * 分组排序 给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
 * <p>
 * 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
 * <p>
 * 请你返回 平滑下降阶段 的数目。
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 0;
        int i = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && prices[i - 1] - prices[i] == 1) {
                i++;
            }
            ans += ((long) (i - start) * (i - start + 1) / 2);
        }
        return ans;
    }
}
