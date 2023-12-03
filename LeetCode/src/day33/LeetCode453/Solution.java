package day33.LeetCode453;

import java.util.Arrays;

public class Solution {
    //正难则反 求其对立事件
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }
}
