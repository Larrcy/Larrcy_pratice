package day60.LeetCode2905;

/**
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。
 * <p>
 * 你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
 * <p>
 * abs(i - j) >= indexDifference 且
 * abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
 * <p>
 * 注意：i 和 j 可能 相等 。
 * 数据范围为10^5
 */
public class Solution {
    /*
    不妨设 i≤j−indexDifference。
    我们可以在枚举 j 的同时，维护 nums[i] 的最大值 mx 和最小值 mn。
    只要满足下面两个条件中的一个，就可以返回答案了。
    mx−nums[j]≥valueDifference
    nums[j]−mn≥valueDifference
    代码实现时，可以维护最大值的下标 maxIdx和最小值的下标 minIdx。
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIdx = 0;
        int minIdx = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }
            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }

        }
        return new int[]{-1, -1};
    }
}
