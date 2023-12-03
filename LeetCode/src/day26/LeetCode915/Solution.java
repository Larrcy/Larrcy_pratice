package day26.LeetCode915;

public class Solution {
    public int partitionDisjoint(int[] nums) {
        //leftMax用来保存数组left中最大的数字
        //index用于划分数组left和right
        int index = 0, max = nums[0], leftMax = max;
        for (int i = 1; i < nums.length; i++) {
            if (leftMax > nums[i]) {
                index = i;
                leftMax = max;
            } else {
                //若leftMax<=nums[i]则对left数组的最大值进行更新
                max = Math.max(max, nums[i]);
            }
        }
        return index + 1;
    }
}
