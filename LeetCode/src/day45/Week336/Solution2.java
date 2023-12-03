package day45.Week336;

import java.util.Arrays;

public class Solution2 {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[nums.length - i];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (sum[i] > 0) count++;

        }
        return count;
    }
}
