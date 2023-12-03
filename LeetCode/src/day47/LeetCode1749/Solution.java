package day47.LeetCode1749;

import java.util.Arrays;

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Arrays.sort(sum);
        return sum[n] - sum[0];
    }
}
