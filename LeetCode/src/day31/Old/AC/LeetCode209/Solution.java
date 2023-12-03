package day31.Old.AC.LeetCode209;

public class Solution {
    //值为target的最小子数组的大小
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; ) {
            if (sum < target) {
                sum += nums[right];
                right++;
                count++;
            }
            while (sum >= target) {
                min = Math.min(count, min);
                sum -= nums[left];
                left++;
                count--;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
