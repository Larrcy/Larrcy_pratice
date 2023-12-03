package day04.LeetCode6285;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,10,3,3,3};
        System.out.println(maxKelements(nums, 3));

    }

    public static long maxKelements(int[] nums, int k) {
        long count = 0;
        while (k >= 0) {
            Arrays.sort(nums);
            count = count + nums[nums.length - 1];
            nums[nums.length - 1] = (int)Math.ceil((double) nums[nums.length - 1] / 3);
            k--;

        }
        return count;
    }
}
