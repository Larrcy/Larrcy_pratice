package day73.dp.LeetCode1671;

import java.util.Arrays;

/**
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 * <p>
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 */
public class Solution {
    //从左到右和从右到左找以nums[i]为最大值的最长递增子序列
    //最后再减去这段长度即为最少需要删除的元素
    public int minimumMountainRemovals(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //下面就是从左到右和从右到左的最长上升子序列
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果当前数字小于顶点，那么更新最小数量
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //由于是山形，因此不能是完全递增或递减，因此顶点必须不是最小值
            if (right[i]>1 && left[i]>1) {
                ans = Math.max(ans, right[i] + left[i]-1);
            }
        }

        return nums.length - ans;
    }
}
