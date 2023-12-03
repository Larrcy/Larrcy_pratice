package Char10.S42.LeetCode674;

import java.util.Arrays;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        //每个长度都至少是1
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) // 连续记录
            dp[i] =dp[i-1] + 1;
            if (dp[i] > res) res = dp[i];
        }


        return res;
    }
}
