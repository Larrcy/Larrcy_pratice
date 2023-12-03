package day22.LeetCode673;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //dp[i]表示下标i结尾的nums数组的最长递增子序列的长度
        int[] dp = new int[n];
        //count记录最长递增子序列的个数
        int[] counter = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //dp[j] + 1 > dp[i]表示第一次找到以nums[i]结尾的最长递增子序列
                    //即以nums[i]结尾的最长递增子序列的组合数=以nums[j]结尾的最长递增子序列的组合数
                    //dp[j] + 1 = dp[i]说明这个长度已经找到过一次了
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //将上一次出现过的也加到本次上来
                        counter[i] += counter[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        //最后遍历dp数组找出最大值的长度
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) res += counter[i];
        }
        return res;

    }
}

