package 模板.二分查找左右边界;
//二分查找可以解决
// 最大化最小值 最小化最大值 第k小等问题
public class Solution {

    //右边界
    public static int BinarySearch1(int[] nums, int target) {
        boolean flag = false;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                flag = true;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return flag == false ? -1 : right;
    }

    //左边界
    public static int BinarySearch2(int[] nums, int target) {
        boolean flag = false;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] == target) {
                flag = true;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return flag == false ? -1 : left;
    }

}
