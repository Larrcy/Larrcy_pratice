package day29.LeetCode918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //求环形子数组的最大和
        //有2种情况
        //1.子数组不是环形的 即子数组首尾不相连
        //2.子数组有一部分在首部一部分在尾部
        //对于子数组在首位的情况我们可以选择用数组总和减去数组中间部分的和
        //极端情况：若数组中所有的数均为负数则第一种情况的最大值为数组中的最大值
        //第二种情况total-total为0 此时应返回数组中的最大值

        //total：数组总和
        //maxSum:最大子数组和    minSum:最小子数组和
        //curMax：包含当前元素的最大子数组和 curMin：包含当前元素的最小子数组和
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}
