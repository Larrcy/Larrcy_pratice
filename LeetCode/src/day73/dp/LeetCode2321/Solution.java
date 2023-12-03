package day73.dp.LeetCode2321;

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度都是 n 。
 *
 * 你可以选择两个整数 left 和 right ，其中 0 <= left <= right < n ，接着 交换 两个子数组 nums1[left...right] 和 nums2[left...right] 。
 *
 * 例如，设 nums1 = [1,2,3,4,5] 和 nums2 = [11,12,13,14,15] ，整数选择 left = 1 和 right = 2，那么 nums1 会变为 [1,12,13,4,5] 而 nums2 会变为 [11,2,3,14,15] 。
 * 你可以选择执行上述操作 一次 或不执行任何操作。
 *
 * 数组的 分数 取 sum(nums1) 和 sum(nums2) 中的最大值，其中 sum(arr) 是数组 arr 中所有元素之和。
 *
 * 返回 可能的最大分数 。
 *
 * 子数组 是数组中连续的一个元素序列。arr[left...right] 表示子数组包含 nums 中下标 left 和 right 之间的元素（含 下标 left 和 right 对应元素）。
 */
public class Solution {
    //设s1=sum(nums[i])
    //交换[left,right]范围内的所有元素
    //s1'=s1-(nums1[left]+...+nums1[right])+(nums2[left]+...+nums2[right])
    //合并得 s1'=s1+(nums2[left]-nums1[left])+...+(nums2[right]-nums1[right])
    //设diff[i]=nums2[i]-nums1[i]
    //s1'=s1+diff[left]+...+diff[right]
    //求diff数组的最大值即可
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1, nums2), solve(nums2, nums1));
    }

    int solve(int[] nums1, int[] nums2) {
        int s1 = 0, maxSum = 0;
        for (int i = 0, s = 0; i < nums1.length; ++i) {
            s1 += nums1[i];
            s = Math.max(s + nums2[i] - nums1[i], 0);
            maxSum = Math.max(maxSum, s);
        }
        return s1 + maxSum;
    }

}
