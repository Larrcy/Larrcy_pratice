package day62.LeetCode34;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        res[1] = BinarySearch1(nums, target);
        res[0] = BinarySearch2(nums, target);

        return res;
    }

    private int BinarySearch2(int[] nums, int target) {
        boolean flag = false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] == target) {
                flag = true;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return flag ? left : -1;
    }


    public int BinarySearch1(int[] nums, int target) {
        boolean flag = false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                flag = true;
                left = mid + 1;
            }
        }
        return flag ? right : -1;
    }

}
