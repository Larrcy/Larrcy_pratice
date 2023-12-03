package day59.LeetCode2562;

import java.util.Arrays;

public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            StringBuilder num = new StringBuilder();
            num.append(nums[left]);
            num.append(nums[right]);
            res += Long.parseLong(num.toString());
            left++;
            right--;
        }
        if (left == right) {
            res += nums[left];
        }
        return res;

    }
}
