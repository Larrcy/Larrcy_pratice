package day29.LeetCode2165;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        long num = (long) Math.pow(10, 15);
        System.out.println(smallestNumber(num));
    }
    public static long smallestNumber(long num) {
        char[] chars = Long.toString(num).toCharArray();
        long[] nums = new long[chars.length];

        if (num >= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = chars[i] - '0';
            }
            int index = 0;
            long sum = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    index++;
                }
            }
            sum = nums[index] * (long) Math.pow(10, index );
            for (int i = index + 1; i < nums.length; i++) {
                sum = sum * 10 + nums[i];
            }
            return sum;
        }
        if (num < 0) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = chars[i] - '0';
            }
            Arrays.sort(nums);
            long sum = 0;
            for (int i = nums.length - 1; i > 0; i--) {
                sum = nums[i]+ sum*10 ;
            }
            return -sum;
        }
        return 0;
    }
}
