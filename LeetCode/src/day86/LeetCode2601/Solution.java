package day86.LeetCode2601;

import java.util.*;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。
 * <p>
 * 你可以执行无限次下述运算：
 * <p>
 * 选择一个之前未选过的下标 i ，并选择一个 严格小于 nums[i] 的质数 p ，从 nums[i] 中减去 p 。
 * 如果你能通过上述运算使得 nums 成为严格递增数组，则返回 true ；否则返回 false 。
 * <p>
 * 严格递增数组 中的每个元素都严格大于其前面的元素。
 */
public class Solution {
    private final static int MX = 1000;
    private final static int[] arr = new int[169];

    static {
        boolean[] np = new boolean[MX + 1];
        int pi = 1; // primes[0] = 0 避免二分越界
        for (int i = 2; i <= MX; ++i)
            if (!np[i]) {
                arr[pi++] = i; // 预处理质数列表
                for (int j = i; j <= MX / i; ++j)
                    np[i * j] = true;
            }
    }



    public boolean primeSubOperation(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= pre) return false;
            int index = binarySearch(arr, nums[i] - pre);
            pre = nums[i] - arr[index];
        }
        return true;
    }

    //筛选出的质数都是从小到大排序的
    //我们可以找到小于nums[i]的最大的质数x
    //使nums[i]-x最小
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //找到小于nums[i]的最大的质数x
                right = mid - 1;
            }
        }
        return right;
    }
}
