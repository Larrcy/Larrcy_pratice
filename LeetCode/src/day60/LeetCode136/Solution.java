package day60.LeetCode136;

/**
 * 给你一个非空整数数组nums
 * 除了某个元素只出现一次以外
 * 其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //利用异或运算进行查找
            res ^= nums[i];
        }
        return res;
    }
}
