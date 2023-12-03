package day64.贪心.LeetCode1764;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 * <p>
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 * <p>
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
 * <p>
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 */
public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length;) {
            //以 nums[k] 为首元素的子数组与 groups[i] 相同，
            // 那么 groups[i]可以找到对应的子数组。
            // 为了满足不相交的要求，我们将 k加上数组 groups[i] 的长度，
            // 并且将 i 加 1
            if (check(groups[i], nums, k)) {
                k += groups[i].length;
                i++;
            } else {
               // 以 nums[k] 为首元素的子数组与 groups[i] 不相同，
                // 那么我们将 k 加 1进行下一次的比较
                k++;
            }
        }
        return i == groups.length;
    }

    public boolean check(int[] g, int[] nums, int k) {
        if (k + g.length > nums.length) {
            return false;
        }
        for (int j = 0; j < g.length; j++) {
            if (g[j] != nums[k + j]) {
                return false;
            }
        }
        return true;
    }


}
