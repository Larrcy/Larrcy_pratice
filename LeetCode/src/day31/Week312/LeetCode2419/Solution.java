package day31.Week312.LeetCode2419;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public int longestSubarray(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num < nums[i]) {
                num = nums[i];
            }
        }
        int[] dp = new int[nums.length];
        //每个长度都至少是1
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]&&nums[i]==num) // 连续记录
                dp[i] =dp[i-1] + 1;
            if (dp[i] > res) res = dp[i];
        }


        return res;
    }

}
