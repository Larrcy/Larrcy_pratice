package day43.LeetCode2563;

import java.util.Arrays;

public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        //固定i的位置找j的位置
        for (int i = 0; i < nums.length; i++) {
            int min = lower - nums[i];
            int max = upper - nums[i];
            int start = BinarySearch2(nums, i+1, nums.length -1, min);
            int end = BinarySearch1(nums, i+1, nums.length - 1, max);
            res += (end - start + 1);
        }
        return res;

    }

    public int BinarySearch1(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }

    public int BinarySearch2(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
