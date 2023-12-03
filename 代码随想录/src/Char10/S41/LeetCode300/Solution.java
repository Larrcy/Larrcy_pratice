package Char10.S41.LeetCode300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i]指以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        //每个长度都至少是1
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
