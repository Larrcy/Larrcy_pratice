package day66.LeetCode2826;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 *
 * 从 0 到 n - 1 的数字被分为编号从 1 到 3 的三个组，数字 i 属于组 nums[i] 。注意，有的组可能是 空的 。
 *
 * 你可以执行以下操作任意次：
 *
 * 选择数字 x 并改变它的组。更正式的，你可以将 nums[x] 改为数字 1 到 3 中的任意一个。
 * 你将按照以下过程构建一个新的数组 res ：
 *
 * 将每个组中的数字分别排序。
 * 将组 1 ，2 和 3 中的元素 依次 连接以得到 res 。
 * 如果得到的 res 是 非递减顺序的，那么我们称数组 nums 是 美丽数组 。
 *
 * 请你返回将 nums 变为 美丽数组 需要的最少步数
 */
public class Solution {
    //正难则反求最长递增子序列然后取反
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] num = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            num[i] = nums.get(i);
        }
        return n-lengthOfLIS(num);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
