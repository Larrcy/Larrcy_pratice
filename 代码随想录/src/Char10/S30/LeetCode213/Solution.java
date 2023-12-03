package Char10.S30.LeetCode213;

public class Solution {
    //打家劫舍环形
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(Rob(nums,1,nums.length-1),Rob(nums,0,nums.length-2));
    }


    public int Rob(int[] nums, int start, int end) {
        //nums长度为2的时候
        if (end == start) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {

            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }
        return dp[end];
    }
}

