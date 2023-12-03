package day36.AC.LeetCode1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            min = nums[k - 1 + i] - nums[i];
            res = Math.min(min, res);
        }
        return res;
    }
}
