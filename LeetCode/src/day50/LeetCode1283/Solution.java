package day50.LeetCode1283;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {200,100,14};
        int threshold = 10;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (func(nums, mid) > threshold) {
                left = mid + 1;

            } else {

                right = mid - 1;
            }

        }

        return left;
    }

    public static int func(int[] nums, int num) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % num != 0) {
                res += 1 + nums[i] / num;
            } else {
                res += nums[i] / num;
            }
        }
        return res;
    }
}
