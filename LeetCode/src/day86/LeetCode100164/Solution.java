package day86.LeetCode100164;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，它只包含 正 整数。
 *
 * 你的任务是通过进行以下操作 任意次 （可以是 0 次） 最小化 nums 的长度：
 *
 * 在 nums 中选择 两个不同 的下标 i 和 j ，满足 nums[i] > 0 且 nums[j] > 0 。
 * 将结果 nums[i] % nums[j] 插入 nums 的结尾。
 * 将 nums 中下标为 i 和 j 的元素删除。
 * 请你返回一个整数，它表示进行任意次操作以后 nums 的 最小长度 。
 */
public class Solution {
    //因为没有限定ij的关系,发现这种操作要么是
    //1.小数将大数从数组中踢掉
    //2.引入一个更小的数,将二者踢掉
    //最后剩下的长度应该和数组中最小值有关,且这个最小值包括操作中可能产生的
    //如果没有产生新的最小值,则很容易知道最后剩下的数就是原始数组中最小值的数量,然后将其两两组合,引进0,就能得到答案
    //如何产生更小值:
    //将所有数与最小值相模如果余数不为0,就为新的最小值
    //只需要产生一个新的更小值就能把所有其他数都踢掉,此时答案是1
    //如果余数全为0,说明所有数都是最小值的倍数,找到原始数组中最小值的数量,然后将其两两组合向上取整
    public int minimumArrayLength(int[] nums) {
        int m = Integer.MAX_VALUE;
        for (int x : nums) {
            m = Math.min(m, x);
        }

        for (int x : nums) {
            if (x % m > 0) {
                return 1;
            }
        }

        int cnt = 0;
        for (int x : nums) {
            if (x == m) {
                cnt++;
            }
        }
        return (cnt + 1) / 2;
    }
}
