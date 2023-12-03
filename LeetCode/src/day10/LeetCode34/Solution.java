package day10.LeetCode34;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    //二分查找也可查带有重复元素的数组
    // 会出现索引不唯一的情况
    //要对此情况进行判断
    public static void main(String[] args) {


    }

    public int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target);
        //对查找的索引进行判断
        //若索引为-1则查找失败
        if (mid == -1) {
            return new int[]{-1, -1};
        }
        //若查找成功 则以查找到的索引为中心向两边进行查找
        int left = mid;
        int right = mid;
        //left != 0要在左边保证短路运算 不然会出现索引越界
        while (left != 0&& nums[left-1] == target ) {
            left--;
        }
        while (right != nums.length - 1&& nums[right+1] == target ) {
            right++;
        }
        //返回左右索引位置
        return new int[]{left, right};
    }
    //编写二分查找函数用于查找索引
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
