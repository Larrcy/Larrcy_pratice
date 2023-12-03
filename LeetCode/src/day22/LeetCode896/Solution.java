package day22.LeetCode896;

public class Solution {
    public boolean isMonotonic(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int p = 0, q = 1; q < nums.length; p++, q++) {
            if (nums[q] <= nums[p]) {
                count1++;
            }
            if (nums[q] >= nums[p]) {
                count2++;
            }
        }
        if (count1 == nums.length - 1 || count2 == nums.length - 1) return true;
        else return false;
    }
}
