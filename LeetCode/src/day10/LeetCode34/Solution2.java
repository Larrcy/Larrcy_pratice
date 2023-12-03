package day10.LeetCode34;

public class Solution2 {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int[] res = new int[2];
        res[1] = BinarySearch1(nums, target);
        res[0] = BinarySearch2(nums, target);

        return res;
    }

    //右边界
    public static int BinarySearch1(int[] nums, int target) {
        //利用flag来控制是否能找到target 找不到-1 找到返回边界
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
