package day26.LeetCode713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int left = 0;
        int sum = 1;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (left<=right&&sum >= k) {
                sum = sum / nums[left];
                left++;
            }
            //加上right到left中子数组的所有组合
            count+=right-left+1;
        }
        return count;
    }
}
