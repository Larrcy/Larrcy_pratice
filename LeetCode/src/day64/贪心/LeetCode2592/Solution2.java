package day64.贪心.LeetCode2592;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[cur] > nums[i]) {
                cur++;
            }
        }
        return cur;
    }
}
