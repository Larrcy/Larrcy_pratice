package day68.双指针.LeetCode2770;

import java.util.Arrays;

public class Solution {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];  // dp[i]表示达到i的最大跳跃次数
        Arrays.fill(dp, -1);    // -1表示到不了这个位置
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // 能从j跳过来且j可以被达到
                if (Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
