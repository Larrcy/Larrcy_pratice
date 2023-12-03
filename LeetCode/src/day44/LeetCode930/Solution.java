package day44.LeetCode930;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int gola = 2;
        System.out.println(numSubarraysWithSum(nums, gola));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        //前缀和
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        int preSum=0;
        for (int num : nums) {
           preSum+=num;
            if (map.containsKey(preSum - goal)) {
                ans += map.get(preSum - goal);
            }
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }

        return ans;
    }

}
