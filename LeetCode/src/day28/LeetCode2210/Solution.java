package day28.LeetCode2210;

public class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                nums[i] = nums[i - 1];
            }
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                count++;
            }
            if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
                count++;
            }

        }
        return count;
    }
}
