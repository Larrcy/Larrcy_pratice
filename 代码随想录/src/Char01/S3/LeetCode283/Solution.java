package Char01.S3.LeetCode283;

public class Solution {
    public void moveZeroes(int[] nums) {
        //双指针移动
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            //右指针不断向右移动
            // 每次右指针指向非零数，则将左右指针对应的数交换
            // 同时左指针右移
            if (nums[right] != 0) {
                //右指针要比左指针快数组中0的个数
                //当右指针所指元素为0时右指针后移一位
                //当进行交换操作时左指针所指的元素为0
                //相当于将0后移
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    //创建两数交换函数
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
