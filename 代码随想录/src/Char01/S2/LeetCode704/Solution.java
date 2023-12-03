package Char01.S2.LeetCode704;

class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] > target) {
                max = mid - 1;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
