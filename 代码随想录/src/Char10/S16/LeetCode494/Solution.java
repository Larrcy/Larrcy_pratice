package Char10.S16.LeetCode494;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //将数组分为两个集合 正数集合left 与负数集合right
        //两个集合相加结果为sum left + right =sum
        //两个集合相减结果为target left-right =target
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int left = (target + sum) / 2;

        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];

    }

}
