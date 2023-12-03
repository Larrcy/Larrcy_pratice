package day44.LeetCode2461;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {9, 18, 10, 13, 17, 9, 19, 2, 1, 18};
        int k = 3;

    }

    public static long maximumSubarraySum(int[] nums, int k) {

        if (k > nums.length) return 0;
        long sum = 0;
        int left = 0;
        long max = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
                count--;

            }

            count++;
            sum += (nums[i]);
            set.add((nums[i]));

            if (count == k) {
                max = Math.max(max, sum);
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
                count--;
            }
        }

        return max;
    }
}

