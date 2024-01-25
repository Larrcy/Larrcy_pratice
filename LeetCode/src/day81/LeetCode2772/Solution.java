package day81.LeetCode2772;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。
 *
 * 你可以对数组执行下述操作 任意次 ：
 *
 * 从数组中选出长度为 k 的 任一 子数组，并将子数组中每个元素都 减去 1 。
 * 如果你可以使数组中的所有元素都等于 0 ，返回  true ；否则，返回 false 。
 *
 * 子数组 是数组中的一个非空连续元素序列。
 */
public class Solution {
    public static boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        //初始化长度为n+1特判k==n时的情况
        int[] d = new int[n + 1];
        //构造差分数组
        //在nums[i]-nums[j]上增加x
        //相当于在d[i]加x在d[j+1]减x
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            d[i] = nums[i] - nums[i - 1];
        }
        //最后一位是哨兵 不需要枚举到n
        for (int i = 0; i < n; i++) {
            //若此时窗口大小不足k且该位置的差分元素不为0则无法使原数组归零
            if (d[i] < 0 || (d[i] != 0 && i + k > n)) return false;
            if (d[i] > 0) {
                d[i + k] += d[i];
                d[i] = 0;
            }
        }
        return true;
    }
}
