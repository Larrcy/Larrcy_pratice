package day23.LeetCode740;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,3,3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] newNums = Arrays.stream(nums).distinct().toArray();
        nums=newNums;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = nums[0]*map.get(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) >= 2) {
                dp[i] = dp[i - 1] + nums[i] * map.get(nums[i]);
            }
            if (Math.abs(nums[i] - nums[i - 1]) == 1) {
                dp[i] = Math.max(dp[i - 1], map.get(nums[i]) * nums[i]);
            }
        }
        System.out.println(nums.length);
        return dp[nums.length - 1];
    }
}
