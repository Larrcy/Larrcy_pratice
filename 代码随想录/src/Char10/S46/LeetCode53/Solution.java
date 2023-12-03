package Char10.S46.LeetCode53;

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        //dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //前面的和不如nums[i-1]大则取nums[i-1]
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            //res 保存dp[i]的最大值
            res = res > dp[i] ? res : dp[i];
        }


        return res;
    }
}
