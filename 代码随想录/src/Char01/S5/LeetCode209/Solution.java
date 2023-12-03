package Char01.S5.LeetCode209;

public class Solution {
    public static void main(String[] args) {

    }

    //滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int right;
        //记录满足条件的数组的长度
        int result = Integer.MAX_VALUE;
        //右指针向右遍历 保证sum>=target
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            //不能是if  左指针要持续向后移动到小于的情况右指针才能继续向后移动
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                //左指针向后移动 同时将sum减去左指针所指位置的元素
                sum = sum - nums[left];
                left++;

            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
