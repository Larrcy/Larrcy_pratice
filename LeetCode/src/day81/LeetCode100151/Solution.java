package day81.LeetCode100151;
import java.util.*;
public class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        // 若中位数回文则直接返回变成中位数的花费
        int mid = nums[nums.length / 2];
        if (isPalindrome(mid)) return cost(nums, mid);

        // 找中位数左/右的最近回文数, 返回较小花费
        int l = mid - 1, r = mid + 1;
        while (l > 1 && !isPalindrome(l)) l--;
        while (r < 1000000000 && !isPalindrome(r)) r++;
        return Math.min(cost(nums, l), cost(nums, r));
    }

    // 将所有元素变为 tar 的花费
    private long cost(int[] nums, int tar) {
        long ret = 0;
        for (int a : nums) ret += Math.abs(a - tar);
        return ret;
    }

    // 9. 回文数
    private boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0, num = x;
        while (num != 0) {
            y = y * 10 + num % 10;
            num /= 10;
        }
        return y == x;
    }




}
