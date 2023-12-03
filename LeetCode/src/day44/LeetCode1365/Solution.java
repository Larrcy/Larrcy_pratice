package day44.LeetCode1365;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[0]) res[0]++;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[nums.length - 1]) res[nums.length - 1]++;
        }
        for (int i = 1; i < nums.length - 1; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) res[i]++;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] < nums[i]) res[i]++;
            }

        }
        return res;
    }
}
