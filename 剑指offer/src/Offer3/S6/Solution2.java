package Offer3.S6;

public class Solution2 {
    //双指针法
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            //同时从数组的左右两端遍历
            //判断nums[i]+nums[j]是否为target
            //若大于则左指针右移
            //若小于则右指针左移
            //最后相等则返回数组
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

}
