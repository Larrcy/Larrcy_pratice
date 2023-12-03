package day36.Need.LeetCode209;

public class Solution {
    public static void main(String[] args) {

    }

    //滑动窗口
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
