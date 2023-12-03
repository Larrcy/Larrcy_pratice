package day57.LeetCode152;

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // 定义：以 nums[i] 结尾的子数组，乘积最小为 dp1[i]
        int[] dp1 = new int[n];
        // 定义：以 nums[i] 结尾的子数组，乘积最大为 dp2[i]
        int[] dp2 = new int[n];

        // base case
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp1[i] = min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
            dp2[i] = max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
        }

        // 遍历所有子数组的最大乘积，求最大值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp2[i]);
        }

        return res;
    }

    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
