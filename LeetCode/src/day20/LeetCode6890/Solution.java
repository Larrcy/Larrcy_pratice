package day20.LeetCode6890;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(findValueOfPartition(nums));
    }

    public static int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int result =Integer.MAX_VALUE;
        for (int p = 0, q = 1; q < nums.length; p++, q++) {
            if (nums[p] == nums[q]) return 0;
            else {
            result=Math.min(result,Math.abs(nums[p]-nums[q]));
            }
        }
        return result;
        }

}
